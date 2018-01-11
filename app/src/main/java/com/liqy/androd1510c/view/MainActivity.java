package com.liqy.androd1510c.view;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import com.liqy.androd1510c.R;
import com.liqy.androd1510c.base.BaseActivity;
import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpData;
import com.liqy.androd1510c.model.User;
import com.liqy.androd1510c.net.RetrofitHelper;
import com.liqy.androd1510c.presenter.GoodsPresenter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends BaseActivity implements IGoodsView {

    @BindView(R.id.tv_hello)
    TextView tv_hello;

    GoodsPresenter presenter;
    private static final int REQUEST_CODE_CHOOSE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new GoodsPresenter(this);
        presenter.getData();

        Matisse.from(MainActivity.this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(9)
//                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    @Override
    public void ok(List<Goods> result) {
        tv_hello.setText(result.toString());
    }

    @Override
    public void failed(String msg) {
        tv_hello.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unBindView();
    }

    public void loginUpload(String phone, String pwd, final File file) {

        //TODO token 验证token

        String loginUrl = "https://www.zhaoapi.cn/user/login";

        RetrofitHelper.getAPI().login(loginUrl, phone, pwd)
                //TODO  flatMap 应用场景？？？
                .flatMap(new Function<HttpData<User>, ObservableSource<HttpData>>() {
                    @Override
                    public ObservableSource<HttpData> apply(HttpData<User> userHttpData) throws Exception {

                        if (userHttpData != null) {
                            User user = userHttpData.data;
                            if (user != null) {
                                //UID
                                RequestBody uid = RequestBody.create(MediaType.parse("multipart/form-data"), user.uid);
                                //TOKEN
                                RequestBody token = RequestBody.create(MediaType.parse("multipart/form-data"), user.token);

                                RequestBody requestImgFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

                                // 创建MultipartBody.Part，用于封装文件数据
                                MultipartBody.Part requestImgPart =
                                        MultipartBody.Part.createFormData("file", file.getName(), requestImgFile);

                                String url = "https://www.zhaoapi.cn/file/upload";
                                return RetrofitHelper.getAPI().upload(url, uid, token, requestImgPart);
                            }
                        }
                        return Observable.empty();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HttpData>() {
                    @Override
                    public void accept(HttpData httpData) throws Exception {
                        Toast.makeText(MainActivity.this, httpData.msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            //TODO 拿到的图片文件 https://github.com/zhihu/Matisse

            List<Uri> uris = Matisse.obtainResult(data);
            Uri uri = uris.get(0);
            //待上传文件 Uri 转 File
            //TODO 剪切（crop） 滤镜（filter） 压缩 （字典查一下）

            File file = new File(getAbsoluteImagePath(this, uri));

            loginUpload("13051151601", "123456", file);
        }
    }

    public static String getAbsoluteImagePath(Activity activity, Uri contentUri) {

        //如果是对媒体文件，在android开机的时候回去扫描，然后把路径添加到数据库中。
        //由打印的contentUri可以看到：2种结构。正常的是：content://那么这种就要去数据库读取path。
        //另外一种是Uri是 file:///那么这种是 Uri.fromFile(File file);得到的
        System.out.println(contentUri);

        String[] projection = {MediaStore.Images.Media.DATA};
        String urlpath;
        CursorLoader loader = new CursorLoader(activity, contentUri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        try {
            int column_index = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            urlpath = cursor.getString(column_index);
            //如果是正常的查询到数据库。然后返回结构
            return urlpath;
        } catch (Exception e) {

            e.printStackTrace();
            // TODO: handle exception
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        //如果是文件。Uri.fromFile(File file)生成的uri。那么下面这个方法可以得到结果
        urlpath = contentUri.getPath();
        return urlpath;
    }
}

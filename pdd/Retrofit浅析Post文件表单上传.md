# Retrofit2使用要点梳理：浅析Post文件/表单上传



实习期的第一个任务就是为项目组预研FACE++智能人脸识别这一新功能。调用旷视FACE++人脸识别接口，进行人脸识别有两种方式：一是通过先上传图片到云存储网站（网盘，云盘，七牛云等）获得图片文件对应的URL参数，通过图片的网络URL参数调用FACE++接口；二是在手机客户端直接上传文件调用FACE++接口。第二种方式需要通过`POST` 请求方式上传图片文件的二进制数据，而我们选择用Retrofit 2来实现这一功能。接下来主要分析第二种情况。请求URL接口调用示例如下：

`https://api-cn.faceplusplus.com/facepp/v3/detect/detection?api_key=YOUR_API_KEY&api_secret=YOUR_API_SECRET&img_file=YOUR_IMAGE_FILE&return_attributes=YOUR_ATTRIBUTE`


<!--more-->


> 其中：`api_key`与`api_secret`字段分别表示你在官网创建应用时创建的对应`api_key`和`api_secret`，`img_file` 字段表示要上传的图片文件的二进制数据，需要用`post multipart/form-data` 方式上传；`return_attributes` 字段表示需要获取的人脸属性，我们这里获取人脸对应的性别和年龄数据即可。


Retrofit 2定义网络请求是通过注解的方式，所以自然我们这里就用到了`@POST` 注解来提交我们的图片文件的二进制数据，需要注意用`@Part MultipartBody.Part` 注解来定义我们要上传的图片文件，用`@Part("attribute") RequestBody` 直接来定义请求中的字符串字段，代码具体如下：



	public interface DetectService {
	    @Multipart //请求体有多部分，使用@MultiPart上传
	    @POST("detection/detect") //URL，可以为空
	    Call<PhotoBean> detect(
	            @Part("api_key") RequestBody request_api_key,
	            @Part("api_secret") RequestBody request_api_secret,
	            @Part MultipartBody.Part request_img_part,
	            @Part("attribute") RequestBody request_attribute
	            );
	}



接下来，我们需要在`MainActivity` 中调用`DetectService` 接口定义的`detect()` 方法发起网络请求，在发起网络请求是，我们需要先创建一下接口方法中定义的4个请求参数，具体代码如下：




	// YOUR_API_KEY，YOUR_API_SECRET，YOUR_ATTRIBUTE
	String apiKey = "YOUR_API_KEY";
	Stirng apiSecret = "YOUR_API_SECRET";
	Stirng attribute = "YOUR_ATTRIBUTE";
	
	// 创建RequestBody，传入参数："multipart/form-data"，String
	RequestBody requestApiKey = RequestBody.create(MediaType.parse("multipart/form-data"), apiKey);
	RequestBody requestApiSecret = RequestBody.create(MediaType.parse("multipart/form-data"), apiSecret);
	RequestBody requestApiAttribute = RequestBody.create(MediaType.parse("multipart/form-data"), attribute);
	
	// 创建RequestBody，传入参数："multipart/form-data"，File
	RequestBody requestImgFile = RequestBody.create(MediaType.parse("multipart/form-data"), imgFile);
	// 创建MultipartBody.Part，用于封装文件数据
	MultipartBody.Part requestImgPart = 
			MultipartBody.Part.createFormData("img_file", imgFile.getName(), requestImgFile);
	
	// 发起网络请求，上传图片我二进制数据
	DetectService service = new DetectService();
	Call<ResponseBody> call = service.detect(requestApiKey, requestApiSecret, requestImgPart, requestApiAttribute);
	call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				// 网络请求成功，处理响应结果
			}
	
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				// 网络请求失败，错误处理
			}
		});




至此，通过Retrofit 2 `@POST` 注解上传文件二进制数据到服务器就完成啦，OK！


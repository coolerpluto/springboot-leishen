**1、拦截器的使用**
    怎么使用：先创建一个自定义的interceptor类，需要实现HandlerInterceptor类。重写三个方法preHandle， postHandle， afterCompletion
    （_preHandle：拦截请求，在控制器执行之前执行。
    postHandle: 在控制器执行完毕，渲染前端之前执行。
    afterCompletion：在前端渲染完毕后执行。_）
    然后将这个拦截器配置一下，写一个配置类实现WebMvcConfigurer，注册到WebMvcConfigurer里面，重写addInterceptors方法，
    去配置这个拦截器拦截哪些请求，不拦截哪些请求。
    具体使用参考：com.fan.interceptor.LoginInterceptor、com.fan.config.AdminWebConfig
    **拦截器原理:**
    1、根据当前请求，找到HandlerExecutionChain【可以处理请求的Handler以及handler的所有拦截器】
    2、先来顺序执行所有拦截器的preHandle方法
        1、如果当前拦截器prehandler返回为true，则执行下一个拦截器的prehandle
        2、如果当前拦截器返回为false。直接倒叙执行所有已经执行了的拦截器的aftercompletion
    3、如果任何一个拦截器返回false，直接跳出不执行目标方法
    4、所有拦截器都返回true，执行目标方法
    5、倒叙执行所有拦截器的
    6、前面的步骤有任何异常都会直接触发aftercompletion
    7、页面成功渲染完成以后，也会倒序触发aftercompletion
    ps:learnImages有拦截器执行顺序
    相关技术博客：SpringBoot下自定义拦截器preHandle方法执行多次原因分析https://blog.csdn.net/weixin_43462591/article/details/88425654
    
    
**文件上传功能**
    前端通过input标签type=file，向后端控制器传输，必须是post方式，后端控制器形参加上注解@RequestPart来拿到，后端需要先判断空，然后使用
    MultipartFile自带功能transferTo功能来向指定路径传输文件。
    具体实现；
    前端上传单个文件，直接在input标签添加type="file",如果是上传多个文件，在添加type="file"基础上，在input标签尾部加multiple如：<input type="file" name="photos" multiple>
    前端请求方式必须是post方式
    后端通过@RequestPart("headerImage") MultipartFile headerImage来获取，
    application.yml配置文件里spring.servlet.multipart.max-file-size是单个文件上传大小限制，max-request-size是请求整体上传大小限制
    具体使用参考src\main\resources\templates\form\form_layouts.html代码395行
                com.fan.controller.FormTestController的upload控制器
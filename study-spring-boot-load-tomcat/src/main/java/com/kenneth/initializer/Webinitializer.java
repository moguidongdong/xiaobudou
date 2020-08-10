package com.kenneth.initializer;

import com.kenneth.config.SpringMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Webinitializer implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        // 1 创建SpringMVC容器
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        // 2 注册我们的配置文件
        app.register(SpringMvcConfig.class);

        // 注册我们的 DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(app);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);  // 最优先启动

    }

}

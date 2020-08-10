package com.kenneth;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;


public class TomcatSpring {

    public static void main(String[] args) {
        // 创建 Tomcat 服务器
        Tomcat tomcatServer = new Tomcat();
        // 指定端口号
        tomcatServer.setPort(9090);
        // 指定项目路径
        StandardContext ctx = (StandardContext) tomcatServer.addWebapp("", new File("study-spring-boot-load-tomcat/src/main").getAbsolutePath());
        // 禁止重新载入
        ctx.setReloadable(false);
        // class文件读取地址
        File additionWebInfClasses = new File("study-spring-boot-load-tomcat/target/classes");
        // 创建webroot
        WebResourceRoot resource = new StandardRoot(ctx);
        // tomcat 内部读取 class 执行
        resource.addPreResources(new DirResourceSet(resource, "/study-spring-boot-load-tomcat/target/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        // 异步等待请求，然后执行
        tomcatServer.getServer().await();
    }
}

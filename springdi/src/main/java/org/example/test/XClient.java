package org.example.test;


import org.example.consumer.XApp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        XApp app = context.getBean(XApp.class);
        app.process("Hi zhanggang" , "zhanggang.com");
        context.close();
    }
}

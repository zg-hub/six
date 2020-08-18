package org.example.test;


import org.example.consumer.AApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        AApp app = context.getBean(AApp.class);
        app.process("Hi Genghong" , "genghong.com");
        context.close();
    }
}

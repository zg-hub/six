package org.example.consumer;

import org.example.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AApp {
    @Autowired
    private Service service;

    public  boolean process(String msg ,String rec) {
        return  this.service.send(msg, rec);
    }

    public void setService(Service service) {
        this.service = service;
    }
}

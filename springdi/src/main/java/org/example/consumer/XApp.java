package org.example.consumer;


import org.example.services.Service;

public class XApp {
    private Service service;

    public  boolean process(String msg ,String rec) {
        return  this.service.send(msg, rec);
    }

    public void setService(Service service) {
        this.service = service;
    }
}

package org.example.services;


public class TwitterServiceImpl implements Service {
    @Override
    public boolean send(String msg, String res) {
        System.out.println("Email sent to "+ res + " with Message=" + msg);
        return false;
    }
}

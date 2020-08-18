package org.example.services;


public class EmailServiceImpl implements Service {
    @Override
    public boolean send(String msg, String res) {
        System.out.println("Email sent to "+ res + " with Message=" + msg);
        return true;
    }
}

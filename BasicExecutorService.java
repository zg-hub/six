package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutorService {
    public static void main(String[] args) {
        final int THREAD=3;
        final int LOOP=3;
        final int TASK=5;
        ExecutorService exec= Executors.newFixedThreadPool(THREAD);
        for(int i=1;i<=TASK;i++){
            Basictask task=new Basictask(i,LOOP);
            exec.submit(task);
        }
        exec.shutdown();
    }
}

class Basictask implements Runnable{
private  int taskId;
private int  loopCount;

    public Basictask(int taskId,int loopCount) {
        this.taskId = taskId;
        this.loopCount=loopCount;
    }

    @Override

    public void run(){
        for(int i=0;i<loopCount;i++){
            try {
                System.out.println("Task"+this.taskId+"iteration");

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Task"+this.taskId+"stopped");

    }
}
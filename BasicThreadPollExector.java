package concurrency;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;


class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + "is rejected");
    }
}

class MyMontitorThread implements Runnable{
    private ThreadPoolExecutor  executor;
    private int  delay;
    private  boolean run =true;

    public MyMontitorThread(ThreadPoolExecutor  executor, int delay) {
        this.executor = executor;
        this.delay = delay;
    }

    public void  shutdown(){
        this.run =false;
    }

    @Override
    public void run() {
        while(run) System.out.println(
                String.format(String.valueOf (this.executor.getPoolSize()),
                        this.executor.getCorePoolSize(),
                        this.executor.getActiveCount(),
                        this.executor.getCompletedTaskCount(),
                        this.executor.getTaskCount(),
                        this.executor.isShutdown(),
                        this.executor.isTerminated())
        );

        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}



class Worker implements  Runnable{
    private  String command;

    public Worker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println (Thread.currentThread ().getName ()+"");
        process();
        System.out.println (Thread.currentThread ().getName ()+" End ");
    }
    private void process(){
        try {
            TimeUnit.SECONDS.sleep (5);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}



class BasicfThreadPollExector {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler rejectedExecutionHandler=new RejectedExecutionHandlerImpl ();
        ThreadFactory threadFactory = Executors.defaultThreadFactory ();
        ThreadPoolExecutor pool=new ThreadPoolExecutor (2,4,10,TimeUnit.SECONDS,new ArrayBlockingQueue<> (2),threadFactory,rejectedExecutionHandler);

        MyMontitorThread montitorTask =new MyMontitorThread (pool,3);
        Thread monitor =new Thread(montitorTask);
        monitor.start();


        for(int i=0;i < 10;i++){
            pool.execute (new Worker ("cmd" + i));
        }

        Thread.sleep (30000);
        pool.shutdown ();
        Thread.sleep (5000);
        montitorTask.shutdown ();
    }
}
/*package concurrency;
import sun.nio.ch.sctp.Shutdown;

import javax.management.monitor.Monitor;
import java.time.LocalDateTime;
import java.util.concurrent.*;

class  RejectedExecutionHandlerImpl implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString()+"is reject");
    }
}

    class MyMontitorThread implements  Runnable{
    private ThreadPoolExecutor executor;
    private  int delay;
    private boolean run=true;

    public MyMontitorThread(ThreadPoolExecutor executor,int delay) {
        this.executor = executor;
        this.delay = delay;
    }
    public void Shutdown() {
        this.run=false;
        }

    public void run(){
        while(run) {
            System.out.println(String.format("[monitor] [%d%d] "+ "Task:%d", this.executor.getCorePoolSize(),
                    this.executor.getCorePoolSize(), this.executor.getActiveCount(), this.executor.getCompletedTaskCount(), this.executor.getTaskCount()
                    , this.executor.isShutdown(), this.executor.isTerminated()));
        }
        try{
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Worker implements Runnable{
    private String command;

    public Worker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start");
        Process();
        System.out.println(Thread.currentThread().getName()+"end");
    }
    private void Process(){
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String toString(){
        return this.command;
    }
}
public class BasicThreadPollExector {
    public static void main(String[] args) throws InterruptedException {


        RejectedExecutionHandler rejectdHandler = new RejectedExecutionHandlerImpl() {

            ThreadFactory threadFactory = Executors.defaultThreadFactory();
            ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, TimeUnit.SECONDS, 10);
            MyMontitorThread montitorTask = new MyMontitorThread(pool, 3);

            Thread montitor = new Thread(MonitorTask);
        Monitor.start();

        for(int i=0;i<10;i++){

            {
                pool.execute(new Worker("cmd" + i));
            }
        Thread.sleep(3000);
        pool.shutdown();
        Thread.sleep(5000);
        MonitorTask.shutdown();
        }
    }
}

*/
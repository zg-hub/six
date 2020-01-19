package concurrency;

public class BasicRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("THREAD START:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("THREAD END:"+Thread.currentThread().getName());
    }

    private void Processing() throws InterruptedException {
        System.out.println("Processing...");
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new BasicRunnable(),"t1");
        Thread t2=new Thread(new BasicRunnable(),"t2");

        System.out.println("starting thread");

        t1.start();
        t2.start();

        System.out.println("runnable threa has been statrted");

        Thread t3=new BasicThread();
        Thread t4=new BasicThread();

        System.out.println("starting thread");

        t3.start();
        t4.start();

        System.out.println("runnable thread has been statrted");
    }
}


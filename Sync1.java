package concurrency;

public class Sync1 implements Runnable{
    static Sync1 t=new Sync1();
    static int n=0;
/*static synchronized void inc(){
// i++;}
    public void run(){
    for (int i=0;i<10000000;i++){
    inc();}

    }*/
    @Override
    public void run() {
        for(int i=0;i<10000000;i++){
            synchronized (t){
             n=i++;}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(n);
    }



}

package concurrency;

public class BasicDomonThread implements Runnable{
    @Override
    public void run() {
while (true){
    Processing();
}
    }


    private void Processing()  {
        System.out.println("Processing daemon Thread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread dt=new Thread(new BasicDomonThread(),"dt");
        dt.setDaemon(true);
        dt.start();

        Thread.sleep(100000);
        System.out.println("Finishing processing");;

    }
}

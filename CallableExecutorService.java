package concurrency;

import java.util.concurrent.*;

public class CallableExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec= Executors.newFixedThreadPool(3);

        CallableTask t=new CallableTask(1);
        Future<Integer> st =exec.submit(t);

        Integer result=st.get();
        System.out.println("TAsk toatl sleep time"+result+"second");

        exec.shutdown();
    }
}
class CallableTask implements Callable<Integer>{

    private int taskId;

    public CallableTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        int total=taskId;
        System.out.println("task"+this.taskId);
        Thread.sleep(5000);

        total+=taskId;
        return total;
    }
}

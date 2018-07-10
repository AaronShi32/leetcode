package skill.juc;

import java.util.concurrent.*;

public class CancelThread {

    private static ExecutorService taskExec = new ThreadPoolExecutor(5, 10,2000,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(20),new ThreadPoolExecutor.DiscardPolicy());

    public static void cancel(Runnable r, long timeout, TimeUnit unit){

        Future<?> task = taskExec.submit(r);

        try {
            task.get(timeout,unit);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            // 如果任务中出现了异常, 则需要重新抛出该异常
        } catch (TimeoutException e) {

        } finally {
            task.cancel(true);
        }

    }
}

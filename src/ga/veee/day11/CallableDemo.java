package ga.veee.day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args)throws Exception {
        ExecutorService es= Executors.newFixedThreadPool(2);

        Future f1=es.submit(new MyCallable());
        try {Thread.sleep(2000);}catch(Exception ignored) {}
        String s1=(String)f1.get();

        System.out.println(s1);

        Future f2=es.submit(new MyCallable());
        String s2=(String)f2.get();

        System.out.println(s2);

        System.out.println("main thread....");
        es.shutdown();
    }
}
class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("call called");
        try {Thread.sleep(2000);}catch(Exception ignored) {}
        return "hello world";
    }
}
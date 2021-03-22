package ga.veee.day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadIntro {
    ThreadIntro() {
//        Thread t2 = new Thread(new MyThreadWork());
//        t2.start();
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.execute(new MyThreadWork());
        es.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadIntro();
        Thread t = Thread.currentThread();
        System.out.println(t);
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }

    }
}

class MyThreadWork implements Runnable{

    @Override
    public void run() {
        System.out.println("Child thread called");
    }
}
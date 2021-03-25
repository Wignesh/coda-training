package ga.veee.day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
    public static void main(String[] args) {
        FireAlarm fireAlarm = new FireAlarm();
        fireAlarm.addObserver(new Student());
        fireAlarm.addObserver(new Teacher());
        fireAlarm.setFire();
    }
}

class FireAlarm extends ThreadObservable {


    public void setFire() {
        setChanged();
        notifyObservers("fire in the mountain run run run"); // signal is sent

    }
}

class Student implements Observer {
    public void runAway(String msg) {
        System.out.println("Student running away ...." + msg);
    }

    @Override
    public void update(Observable o, Object arg) {
        runAway((String) arg);
    }

}

class Teacher implements Observer {
    public void runAway(String msg) {
        System.out.println("Thinking");
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
        System.out.println("Teacher running away ...." + msg);

    }

    @Override
    public void update(Observable o, Object arg) {
        runAway((String) arg);
    }
}

class ThreadObservable extends Observable {
    ExecutorService es;

    public ThreadObservable() {
        es = Executors.newFixedThreadPool(2);
    }

    ArrayList<Observer> v = new ArrayList<>();

    @Override
    public synchronized void addObserver(Observer o) {
        v.add(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        Iterator<Observer> e = v.iterator();
        while (e.hasNext()) {
            Observer o = e.next();
            es.execute(() -> {
                o.update(this, arg);
            });
        }
        es.shutdown();
    }
}

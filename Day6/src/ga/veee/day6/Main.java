
package ga.veee.day6;

public class Main {
    public static void main(String[] args) {
//        Shaitan shaitan = new Shaitan();
//        while (true) {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Enter to pull the chain...");
//            scan.next();
//            shaitan.pull();
//        }
        Fan fan = new Fan();
        Khaitan khaitan = new Khaitan();

        fan.pull();
        fan.pull();
        fan.pull();
        fan.pull();

        khaitan.pull();
        khaitan.pull();
        khaitan.pull();
        khaitan.pull();

        System.out.println(fan.toString());
    }

    static class Fan {

        private Speed current;
        int state;

        public Fan() {
            current = new Off();
            this.state = 0;
        }

        public void setState(Speed state, int spd) {
            current = state;
            this.state = spd;
        }

        public void pull() {
            current.pull(this);
        }

        @Override
        public String toString() {
            return String.format("Fan state %d", state);
        }
    }

    interface Speed {
        void pull(Fan fan);
    }


    static class Off implements Speed {
        public void pull(Fan fan) {
            fan.setState(new Sp1(), 1);
        }
    }

    static class Sp1 implements Speed {
        public void pull(Fan fan) {
            fan.setState(new Sp2(), 2);
        }
    }

    static class Sp2 implements Speed {
        public void pull(Fan fan) {
            fan.setState(new Sp3(), 3);
        }
    }

    static class Sp3 implements Speed {
        public void pull(Fan fan) {
            fan.setState(new Off(), 0);
        }
    }
}

class Khaitan {
    private State state;

    public final void setState(State state) {
        this.state = state;
    }

    public Khaitan() {
        this.state = new SwitchOffState();
    }

    public void pull() {
        state.pull(this);
    }
}

abstract class State {
    public abstract void pull(Khaitan khaitan);
}

class SwitchOffState extends State {

    @Override
    public void pull(Khaitan khaitan) {
        System.out.println("switch on state.................");
        khaitan.setState(new LowSpeedState());
    }
}

class LowSpeedState extends State {
    @Override
    public void pull(Khaitan khaitan) {
        System.out.println("low speed state....");
        khaitan.setState(new MediumSpeedState());
    }
}

class MediumSpeedState extends State {
    @Override
    public void pull(Khaitan khaitan) {
        System.out.println("Medium speed state....");
        khaitan.setState(new HighSpeedState());
    }
}

class HighSpeedState extends State {
    @Override
    public void pull(Khaitan khaitan) {
        System.out.println("high speed state.....");
        khaitan.setState(new SwitchOffState());
    }
}

class Shaitan {

    int state = 0;

    public void pull() {
        switch (state) {
            case 0: {
                System.out.println("switch on state....");
                state = 1;
                break;
            }
            case 1: {
                System.out.println("medium speed state....");
                state = 2;
                break;
            }
            case 2: {
                System.out.println("high speed state.....");
                state = 3;
                break;
            }
            case 3: {
                System.out.println("switch off state....");
                state = 0;
                break;
            }
        }
    }
}
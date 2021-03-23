package ga.veee.day12;

public class EnumDemo {
    public static void main(String[] args) {
        Cars c;
        c = Cars.honda;
        met(c);
        Cars cc[] = c.values();
        for (Cars car : cc) {
            System.out.println(car + " price is : " + car.getPrize());
        }

    }

    public static void met(Cars c) {
        switch (c) {
            case maruthi: {
                System.out.println("The car is maruti.........");
                break;
            }
            case suzuki: {
                System.out.println("its suzuki...........");
                break;
            }
            default: {
                System.out.println("default...........ambi");
            }
        }
    }
}

enum Cars {
    maruthi(1000), suzuki, honda, nissan;
    int prize;

    Cars() {
        System.out.println("cons called....");
    }

    Cars(int prize) {
        System.out.println(this.name() + " car price is : " + prize);
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }
}
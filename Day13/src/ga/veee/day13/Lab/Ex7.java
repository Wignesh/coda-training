package ga.veee.day13.Lab;

public class Ex7 {
    public static void main(String[] args) {

    }
}

interface Hungry<E> {
    void munch(E x);
}

interface Carnivore<E extends Animal> extends Hungry<E> {
}

interface Herbivore<E extends Plant> extends Hungry<E> {
}

abstract class Plant {
}

class Grass extends Plant {
}

abstract class Animal {
}

class Sheep extends Animal implements Herbivore<Plant> {

    public void munch(Plant x) {

    }
}

class Wolf extends Animal implements Carnivore<Sheep> {
    public void munch(Sheep x) {
    }
}
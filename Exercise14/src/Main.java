class Animal {
    // Parent class Animal
}

class Dog extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("The dog is running.");
    }

    @Override
    public void speak() {
        System.out.println("The dog is barking.");
    }
}

class Cat extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("The cat is running.");
    }

    @Override
    public void speak() {
        System.out.println("The cat is meowing.");
    }
}

interface Run {
    void run();
}

interface Speak {
    void speak();
}

class HomeAnimal<T extends Animal & Run & Speak> {
    T animal;

    public HomeAnimal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void showType() {
        System.out.println("Type: " + animal.getClass().getSimpleName());
    }

    public void sleepOnTheCouch() {
        System.out.println("The " + animal.getClass().getSimpleName() + " is sleeping on the couch.");
    }
}

public class Main {
    public static void main(String[] args) {
        HomeAnimal<Dog> dogHome = new HomeAnimal<>(new Dog());
        HomeAnimal<Cat> catHome = new HomeAnimal<>(new Cat());

        dogHome.getAnimal().run();
        dogHome.getAnimal().speak();
        dogHome.showType();
        dogHome.sleepOnTheCouch();

        catHome.getAnimal().run();
        catHome.getAnimal().speak();
        catHome.showType();
        catHome.sleepOnTheCouch();
    }
}



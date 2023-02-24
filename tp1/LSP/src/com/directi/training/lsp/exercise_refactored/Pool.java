package com.directi.training.lsp.exercise_refactored;

public class Pool {
    public void run() {
        Duck donaldDuck = new Duck();
        Duck electricDuck = new ElectronicDuck();
        quack(donaldDuck, electricDuck);
        swim(donaldDuck, electricDuck);
    }

    private void quack(Duck... ducks) {
        for (Duck duck : ducks) {
            if (duck.canQuack())
                duck.quack();
        }
    }

    private void swim(Duck... ducks) {
        for (Duck duck : ducks) {
            if (duck.canSwim())
                duck.swim();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.run();
    }
}

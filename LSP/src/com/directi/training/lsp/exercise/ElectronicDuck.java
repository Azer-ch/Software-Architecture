package com.directi.training.lsp.exercise;

public class ElectronicDuck extends Duck
{
    private boolean _on = false;

    @Override
    public boolean canQuack() {
        return _on;
    }

    @Override
    public boolean canSwim() {
        return _on;
    }

    public void quack()
    {
        if (_on) {
            System.out.println("Electronic duck quack...");
        } else {
            throw new RuntimeException("Can't quack when off");
        }
    }

    public void swim()
    {
        if (_on) {
            System.out.println("Electronic duck swim");
        } else {
            throw new RuntimeException("Can't swim when off");
        }
    }

    public void turnOn()
    {
        _on = true;
    }

    public void turnOff()
    {
        _on = false;
    }
}

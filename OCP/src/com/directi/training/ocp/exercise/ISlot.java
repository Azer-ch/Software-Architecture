package com.directi.training.ocp.exercise;

public interface ISlot {
    public void free(int resourceId);
    public int allocate();
}

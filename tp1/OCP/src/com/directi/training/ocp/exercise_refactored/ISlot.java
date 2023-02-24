package com.directi.training.ocp.exercise_refactored;

public interface ISlot {
    public void free(int resourceId);
    public int allocate();
}

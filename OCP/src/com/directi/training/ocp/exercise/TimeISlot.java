package com.directi.training.ocp.exercise;

public class TimeISlot implements ISlot {
    @Override
    public void free(int resourceId) {
        markTimeSlotFree(resourceId);
    }

    @Override
    public int allocate() {
        int resourceId = findFreeTimeSlot();
        markTimeSlotBusy(resourceId);
        return resourceId;
    }

    private void markTimeSlotFree(int resourceId) {
    }

    private void markTimeSlotBusy(int resourceId) {
    }

    private int findFreeTimeSlot() {
        return 0;
    }
}

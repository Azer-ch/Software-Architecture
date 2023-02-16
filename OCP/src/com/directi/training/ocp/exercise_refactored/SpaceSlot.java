package com.directi.training.ocp.exercise_refactored;

public class SpaceSlot implements ISlot {
    public void free(int resourceId) {
        markSpaceSlotFree(resourceId);
    }

    @Override
    public int allocate() {
        int resourceId = findFreeSpaceSlot();
        markSpaceSlotBusy(resourceId);
        return resourceId;
    }

    private void markSpaceSlotFree(int resourceId) {
    }

    private void markSpaceSlotBusy(int resourceId) {
    }

    private int findFreeSpaceSlot() {
        return 0;
    }
}

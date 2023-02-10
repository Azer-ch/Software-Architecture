package com.directi.training.ocp.exercise;

public class ResourceAllocator
{

    public int allocate(ISlot slot)
    {
        return slot.allocate();
    }

    public void free(ISlot slot , int resourceId)
    {
       slot.free(resourceId);
    }
}

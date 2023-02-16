package com.directi.training.dip.exercise_refactored;

import java.util.HashMap;
import java.util.Map;

public class MyDatabase implements IDatabase
{
    private static MyDatabase _instance;
    private static Map<Integer, String> _data = new HashMap<>();
    private static int _count = 0;

    private MyDatabase(){
    }
    public int write(String inputString)
    {
        _data.put(++_count, inputString);
        return _count;
    }
    public static MyDatabase getInstance(){
        if(_instance == null){
            _instance = new MyDatabase();
        }
        return _instance;
    }
}

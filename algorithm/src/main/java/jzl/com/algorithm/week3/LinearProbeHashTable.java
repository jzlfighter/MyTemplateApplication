package jzl.com.algorithm.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * com.example.administrator.mytemplateapplication.tools.utils
 * Created by kingj on 2020/4/14 0014.
 */
public class LinearProbeHashTable {

    private int n;
    private int m = 31;
    private Object[] keys = new Comparable[m];
    private Object[] values = new Object[m];

    public void put(Object k, Object value) {
        int i;
        for (i = k.hashCode() % m; ; i = i = (i + 1) % m) {
            if (keys[i] == k){
                values[i] = value;
                break;
            }else if(keys[i] == null){
                keys[i] = k;
                values[i] = value;
                break;
            }
        }
    }

}

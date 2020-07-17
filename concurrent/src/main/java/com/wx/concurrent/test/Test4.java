package com.wx.concurrent.test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: Mr.Wang
 * Date: 2019/11/10
 */
public class Test4 {
    private int[] ints = {1, 2, 3};

    public int[] getInts() {
        return ints;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(Arrays.toString(test4.getInts()));

        test4.getInts()[1] = 555;
        System.out.println(Arrays.toString(test4.getInts()));
        for (String arg : args) {
        }

        Map<String, String> hashMap = new HashMap();
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.forEach((k, v) -> {
                    System.out.println(k + ":" + v);
                }
        );
        List<String> stringList=new ArrayList<>();


    }
}

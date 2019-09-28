package com.jugheadzhou.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: ErgodicHashMap
 * @Description: 遍历hashmap
 * @Author: zhaoRong
 * @Create: 2019/6/23 16:25
 **/
public class ErgodicHashMap {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (Integer s : map.keySet()) {
            System.out.println(s + "," + map.get(s));
        }
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}

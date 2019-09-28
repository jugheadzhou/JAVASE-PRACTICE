package com.jugheadzhou.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: HashMapTest
 * @Description: 测试hash
 * @Author: zhaoRong
 * @Create: 2019/6/22 13:58
 **/
public class HashMapTest {
    public static void main(String[] args) {

        Student s1 = new Student("1", "小明", 3);
        Student s2 = new Student("1", "小李", 5);

        Map<Student, Integer> map = new HashMap();
        map.put(s1, 1);
        System.out.println(map.get(s1));

        s1.setAge(4);
        System.out.println(map.get(s1));


        Map map1 = new LinkedHashMap();
        map1.put("1","1");
        map1.put("2","1");
        map1.put("3","1");

//        Map map2 = new LinkedHashMap();
//        map1.put("1","1");
//        map1.put("2","1");
//        map1.put("3","1");

        Iterator iterator = map1.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            map1.put(entry.getKey(),"4");
        }
        String s = "Data too long for column 'params',if you need to see parameter values,please read the logs";
        System.out.println(s.length());
        System.out.println(s.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(",");
        sb.append("3");
        sb.append("}");
        sb.delete(1,2);

        System.out.println(sb.toString());
//
//
//        map.put(s2,2);
//        System.out.println(map.containsKey(s1));
//        System.out.println(map.containsKey(s2));
//        System.out.println(map.get(s1));
//        System.out.println(map.get(s2));
    }
}

package com.jugheadzhou.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HashMapToString
 * @Description:
 * @Author: zhaoRong
 * @Create: 2019/7/14 11:32
 **/
public class HashMapToString {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("url","test");
        map.put("url","test1");
        map.put("url2","test");
        map.put("url3","test");
        String s = map.toString();
        System.out.println(s);
    }
}

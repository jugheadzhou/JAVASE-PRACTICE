package com.jugheadzhou.map.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: TreeMapTest
 * @Description: treemap测试类
 * @Author: zhaoRong
 * @Create: 2019/6/25 10:55
 **/
public class TreeMapTest {
    public static void main(String[] args) {
        MyComparator myComparator = new MyComparator();
        Map<String, String> map = new TreeMap<>(myComparator);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("e", "e");
        map.put("d", "d");
        TreeMapTest treeMapTest = new TreeMapTest();
        treeMapTest.printTreeMap(map);
        treeMapTest.printTreeMapByIterator(map);
        treeMapTest.printTreeMapByIteratorKey(map);
    }

    //推荐使用
    private void printTreeMap(Map<String, String> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    private void printTreeMapByIterator(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    private void printTreeMapByIteratorKey(Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + map.get(key));
        }
    }
}

package com.jugheadzhou.map.treemap;

import java.util.Comparator;

/**
 * @ClassName: MyComparator
 * @Description: 自定义比较器 返回treemap的逆序
 * @Author: zhaoRong
 * @Create: 2019/6/25 10:52
 **/
public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return -s1.compareTo(s2);
    }
}

package com.jugheadzhou.compara;

import java.util.Comparator;

/**
 * @ClassName: Person
 * @Description: 1
 * @Author: zhaoRong
 * @Create: 2019/6/22 9:37
 **/
public class Person implements Comparator<Person> {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age.compareTo(o2.age);
    }
}

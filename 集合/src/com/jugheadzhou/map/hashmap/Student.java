package com.jugheadzhou.map.hashmap;

/**
 * @ClassName: Student
 * @Description: 学生实体类
 * @Author: zhaoRong
 * @Create: 2019/6/22 13:51
 **/
public class Student {

    private String pkId;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String pkId, String name, int age) {
        this.pkId = pkId;
        this.name = name;
        this.age = age;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        if (!getPkId().equals(student.getPkId())) return false;
        return getName().equals(student.getName());

    }

    @Override
    public int hashCode() {
        int result = getPkId().hashCode();
//        result = 31 * result + getName().hashCode();
//        result = 31 * result + getAge();
        return result;
    }
}

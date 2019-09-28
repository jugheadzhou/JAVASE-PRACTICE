package com.jugheadzhou.compara;

/**
 * @ClassName: Dog
 * @Description: 狗这个动物的实体类
 * @Author: zhaoRong
 * @Create: 2019/6/22 9:12
 **/
public class Dog implements Comparable {
    private String dogName;

    private int dogAge;

    private Integer num;

    public Dog() {
    }

    public Dog(String dogName, int dogAge, Integer num) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            Integer age = this.dogAge;
            return age.compareTo(dog.dogAge);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog dog = (Dog) o;

        if (getDogAge() != dog.getDogAge()) return false;
        if (!getDogName().equals(dog.getDogName())) return false;
        return getNum().equals(dog.getNum());

    }

    @Override
    public int hashCode() {
        int result = getDogName().hashCode();
        result = 31 * result + getDogAge();
        result = 31 * result + getNum().hashCode();
        return result;
    }
}

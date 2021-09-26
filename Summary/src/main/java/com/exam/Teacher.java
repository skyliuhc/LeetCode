package com.exam;

public class Teacher extends Person {
    public int b;

    public static void main(String[] args) {
        Person p = new Person();
        Teacher t = new Teacher();
        int i;
//        i=p.a;//a错 私有属性
        i=t.b;
        i=p.change(30);
    }
}

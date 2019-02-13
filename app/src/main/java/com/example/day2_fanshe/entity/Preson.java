package com.example.day2_fanshe.entity;

public class Preson {

    private int age;
    public String name;

    public Preson() {
        System.out.println("共有无参构造器");
    }

    public Preson(int age) {
        System.out.println("共有有参构造器"+age);
    }

    private Preson (int age,String name){
        System.out.println("私有有参构造器"+"age:"+age+"name:"+name);
    }

    public void fun0(){
        System.out.println("共有方法");
    }

    public void fun1(int age){
        System.out.println("共有方法:"+age);
    }

    private void fun2(int age){
        System.out.println("私有方法:"+age);
    }

    public void getAge(){
        System.out.println("age=="+age);
    }

}

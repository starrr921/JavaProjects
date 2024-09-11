package com.demo.PolymorphicTest;

//D:\开发语言材料\Java\day14-面向对象进阶（多态&包&final&权限修饰符&代码块）

public class Test {
    public static void main(String[] args) {
        Person person = new Person("老王",30);
        Animal dog = new Dog(2,"黑");
        Animal cat = new Cat(3,"灰");
        person.keepPet(dog,"骨头");
        person.keepPet(cat,"鱼");
    }
}

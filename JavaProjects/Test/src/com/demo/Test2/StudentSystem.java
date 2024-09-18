package com.demo.Test2;

//D:\开发语言材料\Java\day11-集合&学生管理系统

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        loop : while (true) {
            System.out.println("-------欢迎来到学生管理系统-------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            Scanner sc = new Scanner(System.in);
            String choose =  sc.next();
            switch (choose){
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
//                    System.out.println("5：退出");
                    // break loop
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }

    }

    public static void addStudent(ArrayList<Student> list){
        System.out.println("---添加学生---");
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加id(返回请输入return)");
        loop : while (true) {
            String id = sc.next();
            if(id.equalsIgnoreCase("return")){
                return;
            }
            if(list.size() == 0){
                stu.setId(id);
                break loop;
            }else {
                for (int i = 0; i < list.size(); i++) {
                    if(id.equals(list.get(i).getId())){
                        System.out.println("id重复请重新设置(返回请输入return)");
                        continue loop;
                    }
                }
                stu.setId(id);
                break loop;
            }
        }
        System.out.println("请输入添加姓名");
        String name = sc.next();
        stu.setName(name);
        System.out.println("请输入添加年龄");
        int age = sc.nextInt();
        stu.setAge(age);
        System.out.println("请输入家庭住址");
        String address = sc.next();
        stu.setAddress(address);
        list.add(stu);
        System.out.println("添加成功");
        return;
    }


    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("---删除学生---");
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加id(返回请输入return)");
        String id = sc.next();
        if(id.equalsIgnoreCase("return")){
            return;
        }
        int flag = findId(list,id);
        if(flag >= 0){
            list.remove(flag);
            System.out.println("清除成功");
        }else {
            System.out.println("id不存在");
            return;
        }
    }


    public static void updateStudent(ArrayList<Student> list){
        System.out.println("---修改学生---");
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加id(返回请输入return)");
        String id = sc.next();
        if(id.equalsIgnoreCase("return")){
            return;
        }
        int flag = findId(list,id);
        if(flag >= 0){
            System.out.println("请输入添加姓名");
            String name = sc.next();
            list.get(flag).setName(name);
            System.out.println("请输入添加年龄");
            int age = sc.nextInt();
            list.get(flag).setAge(age);
            System.out.println("请输入家庭住址");
            String address = sc.next();
            list.get(flag).setName(address);
            System.out.println("修改成功");
        }else {
            System.out.println("id不存在");
            return;
        }
    }


    public static void queryStudent(ArrayList<Student> list){
        System.out.println("---查询学生---");
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入添加id(返回请输入return)");
        System.out.println("输入all表示查询全部");
        String id = sc.next();
        if(id.equalsIgnoreCase("return")){
            return;
        }
        if(id.equalsIgnoreCase("all")){
            if(list.size() == 0){
                System.out.println("当前无学生信息，请添加后再查询");
            }else {
                System.out.println("id\t 姓名\t 年龄\t 家庭住址\t");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getId() + "\t" + list.get(i).getName()
                            + "\t" + list.get(i).getAge() + "\t" + list.get(i).getAddress());
                }
                return;
            }
        }
        int flag = findId(list,id);
        if(flag >= 0){
            System.out.println(list.get(flag).getId() + ", " + list.get(flag).getName()
                    + ", " + list.get(flag).getAge() + ", " + list.get(flag).getAddress());
        }else {
            System.out.println("当前无学生信息，请添加后再查询");
        }

    }


    public static int findId(ArrayList<Student> list, String id){
        if(list.size() == 0){
            return -1;
        }else {
            for (int i = 0; i < list.size(); i++) {
                if (id.equals(list.get(i).getId())) {
                    return i;//index
                }
            }
            return -1;
        }
    }


}

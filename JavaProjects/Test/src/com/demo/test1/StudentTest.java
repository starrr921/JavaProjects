package com.demo.test1;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Student stu1 = new Student(1, "zhangsan", 10);
        Student stu2 = new Student(2, "lisi", 20);
        Student stu3 = new Student(3, "wangwu", 30);
        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;


        Student stu4 = new Student(4, "liuliu", 40);
        boolean flag1 = checkId(arr,stu4);
        if(flag1){
            System.out.println("有问题，重新输入");
        }else {
            //判断是否超限
            int count = getNum(arr);
            if(count == arr.length){
                //创建新数组
                Student[] NewArr = createNewArr(arr);
                NewArr[count] = stu4;
                arr = NewArr;
            }else {
                arr[count] = stu4;
            }
        }
        print(arr);
        //get要删除的ID
        System.out.println("选择删除的ID");
        int id1 = getId();
        //进行删除操作
        deleteInfo(arr,id1);
        //遍历信息
        print(arr);
        //查找id
        System.out.println("选择查找修改的ID");
        int id2 = getId();
        int index = getIndex(arr,id2);
        if(index >= 0){
            Student stu = arr[index];
            int newAge = stu.getAge() + 1;
            stu.setAge(newAge);
        }
        print(arr);

    }


    public static Boolean checkId(Student[] arr, Student info) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getId() == info.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static Boolean checkId(Student[] arr, int id) {
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i].getId() == id) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static int getNum(Student[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                count++;
            }
        }
        return count;
    }

    public static Student[] createNewArr(Student[] arr){
        Student[] NewArr = new Student[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            NewArr[i] = arr[i];
        }
        return NewArr;
    }

    public static void print(Student[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                System.out.println(arr[i].getId() + ", " + arr[i].getName() + ", " + arr[i].getAge());
            }
        }
    }

    public static int getId(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void deleteInfo(Student[] arr, int id){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getId() == id){
                arr[i] = null;
                return;
            }
        }
        System.out.println("删除失败");
    }

    public static int getIndex(Student[] arr,int id){
        int index;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                if (arr[i].getId() == id) {
                    index = i;
                    return index;
                }
            }
        }
        System.out.println("搜索失败");
        return -1;
    }
}

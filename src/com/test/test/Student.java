package com.test.test;

import java.util.Scanner;

/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/10 18:07
 */
public class Student {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输出数组的长度");
        int number=input.nextInt();//输入学生的个数;
        String[] name=new String[number];//定义字符串型的数组;
        int[] grade=new int[number];//定义int型的数组;
        for(int i=0;i<number;i++) {
            System.out.println("请输入您的name");
            name[i]=input.next();
            System.out.println("请输入您的成绩：");
            grade[i]=input.nextInt();
        }
        int max=grade[0];
        String maxname=name[0];
        for (int i = 0; i < number; i++) {
            if (max<grade[i]){
                max=grade[i];
                maxname=name[i];
            }
        }
        System.out.println("最大的是"+maxname+":"+max);
/*        System.out.println("小于60分为不及格==》");
        for (int i = 0; i <number; i++) {
            if (grade[i]<60){
                System.out.println("name is " + name[i]+"成绩 is " + grade[i]);
            }
            else{
                System.out.println("没有不及格的");
            }
        }*/
        System.out.println("请输入您要查询的学生name");
        String quer = input.next();
        quer=name[0];
        for (int i = 0; i < number; i++) {
            if (quer.equals(name[i])){
                System.out.println("name is " + name[i]+"成绩 is " + grade[i]);
                return;
            }
            else{
                System.out.println("查不出人");
            }
        }
        System.out.println("==========");
        for(int i=0;i<number-1;i++)//冒泡排序
        {
            for(int j=0;j<number-1-i;j++) {
                if(grade[j]>grade[j+1])
                {
                    int temp=grade[j];
                    grade[j]=grade[j+1];
                    grade[j+1]=temp;
                    String temp_c=name[j];
                    name[j]=name[j+1];
                    name[j+1]=temp_c;
                }
            }
        }
        for(int i=0;i<number;i++)
        {
            System.out.println("name is " + name[i]+"成绩 is " + grade[i]);
        }
        input.close();

    }
}

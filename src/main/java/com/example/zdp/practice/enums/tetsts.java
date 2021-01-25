package com.example.zdp.practice.enums;

/**
 * @ClassName tetsts
 * @Author dongping
 * @Date 2020/8/25 15:07
 * @Description tetsts
 * @Version 1.0
 */
public class tetsts {
    public static void main(String[] args) {
        int i=2;
        Tenum tenum = Tenum.values(i);
        String name = tenum.getName();
        System.out.println(name);

    }
}

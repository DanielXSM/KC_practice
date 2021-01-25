package com.example.zdp.practice.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Tenum
 * @Author dongping
 * @Date 2020/8/25 14:59
 * @Description Tenum
 * @Version 1.0
 */
public enum Tenum {
    Cat(1){
        @Override
        public String getName() {
            return "猫";
        }
    },

    Dog(2){
        @Override
        public String getName() {
            return "狗";
        }
    };
    int a;

    Tenum(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    public abstract String getName();

   public static Tenum values(int i){
       Tenum[] values = Tenum.values();
       List<Tenum> collect = Arrays.asList(values).stream().filter(v -> v.getA() == i).collect(Collectors.toList());
       return collect.get(0);
   }

}


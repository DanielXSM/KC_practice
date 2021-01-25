package com.example.zdp.practice.test;


import java.util.Optional;

/**
 * @ClassName Solution
 * @Author dongping
 * @Date 2020/11/19 16:08
 * @Description Solution
 * @Version 1.0
 *
 */
public class Solution {
    public static void main(String[]args){
        Optional<Integer> integer = Optional.ofNullable(null);
        System.out.println(integer.orElseGet(()->1));
//        System.out.println(reverses(120));
    }
    public static int reverse(int x) {
        int res=0;
        if(x>0){
            while(x>0){
                if((res*10+x%10)/10!=res){
                    return 0;
                }
                res=res*10+x%10;
                x=x/10;
            }
        }
        if(x<0){
            while(x<0){
                if((res*10+x%10)/10!=res){
                    return 0;
                }
                res=res*10+x%10;
                x=x/10;
            }
        }
        return res;
    }

    /**
     * 标准答案
     *
     * @param x
     * @return
     */
    public static int  reverses(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {return 0;}
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {return 0;}
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

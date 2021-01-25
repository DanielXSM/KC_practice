package com.example.zdp.practice.test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName forTest
 * @Author dongping
 * @Date 2021/1/6 14:35
 * @Description forTest
 * @Version 1.0
 */
public class forTest {


   /* private static AtomicInteger counter = new AtomicInteger(0);

        TimeUnit timeUnit=TimeUnit.SECONDS;
        System.out.println( timeUnit.toMillis(1));*/
      /*  int andIncrement = counter.incrementAndGet();
        System.out.println(andIncrement);*/
   public int singleNumber(int[] nums) {
       Map<Integer,Integer>maps=new HashMap();
       for(int i:nums){
           Integer count=maps.get(i);
           if(null==count){
               maps.put(i,1);
           }else {
               maps.put(i,++count);
           }
       }
       int a=0;
       for(Map.Entry<Integer,Integer> entry:maps.entrySet()){
           if(entry.getValue()>nums.length/2){
               a= entry.getKey();
           }
       }
       return a;
   }
    public static void main(String[] args) {
       Boolean c=true;
       Boolean d=false;
        System.out.println(c.equals(Boolean.TRUE));
//        System.out.println(Boolean.toString(true));

      /* String a="-12.123456789";

        try {
            BigDecimal bigDecimal=new BigDecimal(a);
            System.out.println(bigDecimal.scale());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
//        System.out.println(7/2);

/*
        List<String> list=new ArrayList<>();
        List<String> collect1 = list.stream().map(a -> a).
                peek(b-> System.out.println(b)).collect(Collectors.toList());
        System.out.println(collect1);*/
      /*  IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2, 3, 4, 5, 6).mapToInt(a->a%3).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getSum());
        long[]  accessTime = new long[1];*/
//        Arrays.fill(accessTime, 0);

//        Stream.of(Arrays.asList("1","2,"""))
//        List<String> a=new ArrayList(){{add("ad");add("c");add("c");}};
//        a.stream().sequential()
//        IntStream.range(1,3)
//        Supplier
//        ToLongFunction
//        Map<String, List<String>> collect = a.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.toList())));
//        Criteria criteria
//        System.out.println(collect.get("c"));
//        a.stream().forEachOrdered(b-> {System.out.println(b);});
//        System.out.println(a.size());
       /* for(int i=0;i<5;i++){
            System.out.println("i的值"+i);
            ++i;

        }*/
    }
}

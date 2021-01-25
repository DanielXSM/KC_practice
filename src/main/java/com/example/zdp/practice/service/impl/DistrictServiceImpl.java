package com.example.zdp.practice.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.zdp.practice.dto.CityTreeVo;
import com.example.zdp.practice.po.District;
import com.example.zdp.practice.dao.DistrictMapper;
import com.example.zdp.practice.service.IDistrictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zdp.practice.service.freight.FreightRuleService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author carrey
 * @since 2020-08-27
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements IDistrictService {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    StringRedisTemplate redisTemplates;

    @Autowired
    FreightRuleService freightRuleService;

    @Override
    @Transactional(rollbackFor = {Exception.class,Error.class})
    public void processFreightRule(){
        District district=new District();
        district.setPid(122);
        baseMapper.insert(district);
        try {
            freightRuleService.add();
        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.println("ok");
    }

    /**
     * 查找一个
     * @return
     */
    @Override
    public String queryOne() {
        QueryWrapper<District> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(District::getCode,2);
        List<District> districts = baseMapper.selectList(queryWrapper);
       /* queryWrapper.lambda().eq(District::getCode,1).orderByDesc(District::getPid,District::getId);
        List<District> district = baseMapper.selectList(queryWrapper);*/
        return districts.get(0).toString();
    }

    /**
     * 更新为空
     */
    @Override
    public void updateDistrict() {
        UpdateWrapper<District> updateWrapper=new UpdateWrapper();
        updateWrapper.lambda().eq(District::getId,1);
        District updateDistrict=new District();
        int update = baseMapper.update(updateDistrict, updateWrapper);
        System.out.println("执行成功数量"+update);
    }


    /**
     * 执行
     * @param args
     */
    public static void main(String[] args) {
     /*   String a="V002";
        String substring = a.substring(1);
        System.out.println(substring);
        //去除多余的0
        String newStr = substring.replaceAll("^(0+)", "");
        System.out.println(newStr);
        int intValue = new BigDecimal(newStr).add(BigDecimal.ONE).intValue();
        //加上新的版本号，补充到3位数
        String str = String.format("%03d", intValue);
//        String strs = String.format("%03d", 15);
//        System.out.println(strs);
        System.out.println(str);
        String cc="V"+str;
        System.out.println(cc);
        String yyyymmdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String rule="WLBJTZ"+yyyymmdd+cc;
        System.out.println(rule);*/

        /*String key= "WLBJ"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String s = redisTemplates.opsForValue().get(key);
        if(StringUtils.isEmpty(s)){
            s="1";
            redisTemplates.opsForValue().set(key,s,24,TimeUnit.HOURS);
        }else{
           s= new BigDecimal(s).add(BigDecimal.ONE).toPlainString();
        }
        String str = String.format("%04d", Integer.parseInt(s));
        String rule=key+str;
        System.out.println(rule);*/
   /*    for(int p=0;p<100;p++){
            String yyyyMMddHHmmss = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
            System.out.println(yyyyMMddHHmmss);
        }
        int i = (int)(Math.random()*900 + 100);
        System.out.println(i);*/
    /*    CityTreeVo cityTreeVo=new CityTreeVo();
        List<CityTreeVo>list=new ArrayList<>();
        CityTreeVo cityTreeVo1=new CityTreeVo();
        cityTreeVo1.setId(1);
        CityTreeVo cityTreeVo2=new CityTreeVo();
        cityTreeVo2.setId(2);
        list.add(cityTreeVo1);
        list.add(cityTreeVo2);
        cityTreeVo.setChild(list);
        cityTreeVo.getChild().forEach(a->{
            if(a.getId()==1){
                a.setCode("插入成功");
            }
            });
        cityTreeVo.getChild().forEach(a-> System.out.println(a.getId()+a.getCode()));*/
    /*String time="2020-09-14"+" 00:00:00";
        LocalDateTime parse = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse.toString());*/

        /*LocalDate signDate=LocalDate.parse("2020-09-07", DateTimeFormatter.ISO_DATE);
        System.out.println(signDate.format(DateTimeFormatter.ISO_DATE));

        BigDecimal bigDecimal=new BigDecimal("10");
        BigDecimal bigDecimal1=new BigDecimal("5");
        BigDecimal divide = bigDecimal.divide(bigDecimal1, 2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(divide.toPlainString());*/
/*        long time = new Date().getTime();
        long l = System.currentTimeMillis();
        System.out.println(time +"");
        System.out.println(l +"");*/
    /*    People people=new People();
        people.setBaby(true);
        System.out.println(new Boolean(true).equals(people.baby));*/
     /*   String  aa="afafa,&afa,";
        String[] split = aa.split("&");
        System.out.println(split[0]+split[1]);*/
        LocalDate localDate=LocalDate.now();


//        System.out.println(parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
   /* Set<String> sets=new HashSet<>();
        sets.add("r");
        sets.add("c");
        sets.add("d");
        sets.add("a");

        System.out.println(sets.toString());*/
/*   String a="A";
   final String b="B";
        switch(a){
            case b:
                System.out.println("a");
                break;
        }*/

/*        BigDecimal remainWeight=new BigDecimal("4");

        BigDecimal continueHeavyWeight=new BigDecimal("3.1");
        BigDecimal divide = remainWeight.divide(continueHeavyWeight, 0, RoundingMode.UP);
        System.out.println(divide.toPlainString());*/


  /*  List<SKY> list=new ArrayList<>();
        SKY sky=new SKY(new BigDecimal("1"));
        SKY sky1=new SKY(new BigDecimal("6"));
        SKY sky2=new SKY(new BigDecimal("8.8"));
        SKY sky3=new SKY(new BigDecimal("9"));
        SKY sky4=new SKY(new BigDecimal("2"));*/
      /*  list.add(sky);
        list.add(sky1);
        list.add(sky2);
        list.add(sky3);
        list.add(sky4);
*/
      /*  Optional<SKY> max = list.stream().max(Comparator.comparing(SKY::getBaby));
        if(max.isPresent()){
            System.out.println("aaa");
        }else{
            SKY sky5 = max.get();
            System.out.println(sky5.getBaby());
        }

    }
    public  String getClassNames(){
       return  getClass().getName();*/
        boolean settlementOrderPO=true;
//       int a= settlementOrderPO?1:0;
//        System.out.println(a);

//        List<SKY> list=new ArrayList<>();
//        SKY sky=new SKY(new BigDecimal("1"));
//        SKY sky1=new SKY(new BigDecimal("6"));
//        SKY sky2=new SKY(new BigDecimal("8.8"));
//        SKY sky3=new SKY(new BigDecimal("1.0"));
//
//
//        SKY sky4=new SKY(new BigDecimal("2"));
//
//        list.add(sky);
//        list.add(sky1);
//        list.add(sky2);
//        list.add(sky3);
//        list.add(sky4);
//        Optional<SKY> max = list.stream().min(Comparator.comparing(SKY::getBaby));
//        if(max.isPresent()){
//            SKY sky5 = max.get();
//            System.out.println(sky5.getBaby());
//            System.out.println("结束");
//        }else{
//            SKY sky5 = max.get();
//            System.out.println(sky5.getBaby());
//        }
//        Float a=3F/0.75F;
//        int i = ;
//        System.out.println(i);
//        String format = String.format(Locale.ROOT, "original-receive-log-pool-%d", 0);
//        System.out.println(format);

       /* int a=(new BigDecimal(7).divide(new BigDecimal("0.75"),0,RoundingMode.HALF_UP).add( BigDecimal.ONE)).intValue();
        System.out.println(a);*/
   /*     ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap(0);
        concurrentHashMap.put("aa",null);
        System.out.println("aaaa");*/
/*   BigDecimal bigDecimal=new BigDecimal(Integer.MAX_VALUE);
        System.out.println(bigDecimal.toPlainString());
        BigDecimal decimal=new BigDecimal(Long.MAX_VALUE);
        System.out.println(decimal);
        BigDecimal b=new BigDecimal("922337203685477580779223372036922337203685477580779223372036854775807792233720368547758077922337203685477580778547758077.1234567890");
        System.out.println(b.toPlainString());
        BigDecimal divide = b.divide(decimal, 2, RoundingMode.HALF_UP);
        System.out.println(divide.toPlainString());*/
        /*BigDecimal bigDecimal=new BigDecimal("2258.89710153");
        BigDecimal bigDecimalS=new BigDecimal("200");
        BigDecimal[]AA=bigDecimal.divideAndRemainder(bigDecimalS);
        System.out.println(AA[0]);
        System.out.println(AA[1]);
*/

   /*     System.out.println(Integer.MIN_VALUE);
        System.exit(0);*/
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        for(int i=0;i<100;i++){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
            System.out.println(simpleDateFormat.format(new Date()));

        }
    }

    @Data
    @AllArgsConstructor
    static class SKY{
        private BigDecimal baby;
    }
    @Data
    static class People{
        private boolean baby;
    }
    @Override
    public List<District> queryProvince(){
        List<District> o = (List<District>)redisTemplate.opsForHash().get("all_districts", "province");

        String province = redisTemplates.opsForValue().get("province");
        if(StringUtils.isNotEmpty(province)){
            List<District> list = JSON.parseArray(province, District.class);
            return list;
        }else{
            QueryWrapper<District>queryWrapper=new QueryWrapper<>();
            queryWrapper.lambda().eq(District::getLevel,"0");
            List<District> districts = this.list(queryWrapper);
            redisTemplates.opsForValue().set("province",JSON.toJSONString(districts),60*10, TimeUnit.SECONDS);
            return districts;
        }




       /* if(null!=o){
            return o;
        }else{
            QueryWrapper<District>queryWrapper=new QueryWrapper<>();
            queryWrapper.lambda().eq(District::getLevel,"0");
            List<District> districts = this.list(queryWrapper);
            redisTemplate.opsForHash().put("all_districts","province",districts);
            return districts;

        }*/
    }

    /**
     * 查询城市
     * @return
     */
    @Override
    public List<District> queryCity() {
        QueryWrapper<District>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(District::getLevel,"1");
        List<District> districts = this.list(queryWrapper);
        return districts;
    }

    /**
     * 查询地区
     * @return
     */
    @Override
    public List<District> queryArea() {
        QueryWrapper<District>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(District::getLevel,"2");
        List<District> districts = this.list(queryWrapper);
        return districts;
    }

    /**
     * 封装地区树形结构
     * @return
     */
    @Override
    public List<CityTreeVo> packageArea(){
        String s = redisTemplates.opsForValue().get("districts");
        if(StringUtils.isNotEmpty(s)){
            List<CityTreeVo> provinces= JSON.parseArray(s, CityTreeVo.class);
            return provinces;
        }else{
            List<District> districts = queryProvince();
            List<District> cityss=queryCity();
            List<District> areass=queryArea();
            List<CityTreeVo> provinces = districts.stream().map(p -> CityTreeVo.builder().id(p.getId()).name(p.getName()).code(p.getCode()).parentId(p.getPid()).build()).collect(Collectors.toList());
            List<CityTreeVo> citys = cityss.stream().map(p -> CityTreeVo.builder().id(p.getId()).name(p.getName()).code(p.getCode()).parentId(p.getPid()).build()).collect(Collectors.toList());
            List<CityTreeVo> areas = areass.stream().map(p -> CityTreeVo.builder().id(p.getId()).name(p.getName()).code(p.getCode()).parentId(p.getPid()).build()).collect(Collectors.toList());
            Map<Integer, List<CityTreeVo>> areasGroup = areas.stream().collect(Collectors.groupingBy(CityTreeVo::getParentId));
            Map<Integer, List<CityTreeVo>> citysGroup = citys.stream().collect(Collectors.groupingBy(CityTreeVo::getParentId));
            citys.forEach(c->c.setChild(areasGroup.get(c.getId())));
            provinces.forEach(t->t.setChild(citysGroup.get(t.getId())));
            redisTemplates.opsForValue().set("districts",JSON.toJSONString(provinces),60*10, TimeUnit.SECONDS);
            return provinces;
        }

    }
    @Override
    public void adds()throws Exception{
        add();
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void add() {
        if(1==1){
            throw new RuntimeException("aa");
        }
    }

    /**
     * 控制台打印
     * @param list
     * @param deep
     */
    @Override
    public  void showTree(List<CityTreeVo> list, int deep,StringBuffer sb){
        list.forEach(l->{
            switch (deep){
                case 1:
                    String name=l.getName();
                    sb.append(name+"\n");
                    System.out.println(name);
                    break;
                case 2:
                    String names="|----" + l.getName();
                    System.out.println(names);
                    sb.append(names+"\n");
                    break;
                case 3:
                    String name3="     |----" + l.getName();
                    System.out.println(name3);
                    sb.append(name3+"\n");
                    break;
            }
            if (l.getChild() != null){
                showTree(l.getChild(),deep + 1,sb);
            }
        });
    }


}

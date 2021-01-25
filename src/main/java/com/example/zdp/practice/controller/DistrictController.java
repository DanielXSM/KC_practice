package com.example.zdp.practice.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.zdp.practice.bo.ReceiveBO;
import com.example.zdp.practice.po.District;
import com.example.zdp.practice.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author carrey
 * @since 2020-08-27
 */
@Controller
public class DistrictController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    IDistrictService iDistrictService;

    @RequestMapping("/district")
    @ResponseBody
    public List<District> queryDistrict() {

        List<District> districts = iDistrictService.queryProvince();

        districts.stream().forEach(d -> System.out.println(d.getName()));
        return districts;

    }

    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        StringBuffer stringBuffer = new StringBuffer();
        iDistrictService.showTree(iDistrictService.packageArea(), 1, stringBuffer);
        return stringBuffer.toString();
    }

    @RequestMapping("/dos")
    @ResponseBody
    public String dos() {
        List<ReceiveBO> lists = new ArrayList<>();
        ReceiveBO receiveBO1 = ReceiveBO.builder().province("天津").city("天津市").build();
        ReceiveBO receiveBO2 = ReceiveBO.builder().province("河北省").city("秦皇岛市").district("抚宁县").build();
        ReceiveBO receiveBO7 = ReceiveBO.builder().province("河北省").city("秦皇岛市").district("昌黎县").build();
        ReceiveBO receiveBO3 = ReceiveBO.builder().province("河北省").city("石家庄市").build();
        ReceiveBO receiveBO4 = ReceiveBO.builder().province("安徽省").build();
        ReceiveBO receiveBO5 = ReceiveBO.builder().province("北京").build();
        ReceiveBO receiveBO6 = ReceiveBO.builder().province("河北省").city("唐山市").district("丰润").build();

        lists.add(receiveBO1);
        lists.add(receiveBO2);
        lists.add(receiveBO3);
        lists.add(receiveBO4);
        lists.add(receiveBO5);
        lists.add(receiveBO6);
        lists.add(receiveBO7);
        return processCity(lists);

    }

    /**
     * 组装数据
     *
     * @param lists
     * @return
     */
    public String processCity(List<ReceiveBO> lists) {
        Map<String, Map<String, List<String>>> maps = new HashMap<>();
        for (ReceiveBO receiveBO : lists) {
            String province = receiveBO.getProvince();
            String city = receiveBO.getCity();
            String district = receiveBO.getDistrict();
            if (StringUtils.isNotEmpty(province)) {
                Map<String, List<String>> stringListMap = maps.computeIfAbsent(province, s -> new HashMap<>());
                if (StringUtils.isNotEmpty(city)) {
                    List<String> stringList = stringListMap.computeIfAbsent(city, e -> new ArrayList<>());
                    if (StringUtils.isNotEmpty(district)) {
                        stringList.add(district);
                    }
                }
            }

        }

        /**
         * 拼接 打印数据
         */
        StringBuilder stringBuilder=new StringBuilder();
        for(Map.Entry<String,Map<String, List<String>>> entry:maps.entrySet()){
            StringBuilder joint=new StringBuilder();
            String key = entry.getKey();
            joint.append(key);
            Map<String, List<String>> value = entry.getValue();
            if(value.size()>0){
                joint.append("(");
                for(Map.Entry<String,List<String>> val:value.entrySet()){
                    String valKey = val.getKey();
                    joint.append(valKey);
                    List<String> valValue = val.getValue();
                    if(!CollectionUtils.isEmpty(valValue)){
                        joint.append(":");
                        for(int i=0;i<valValue.size();i++){
                            String s = valValue.get(i);
                            if(i==0){
                                joint.append(s);
                            }else{
                                joint.append("、"+s);
                            }
                        }
                    }
                    joint.append(";");
                }
                String returnstr=joint.substring(0,joint.length()-1);
                joint.replace(0,joint.length(),returnstr);
                joint.append(")");
            }
            joint.append("、");
            stringBuilder.append(joint.toString());
        }
        String result="";
        if(stringBuilder.length()>0){
            result=stringBuilder.substring(0,stringBuilder.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> maps = new HashMap<>();
    /*    List<String>l1=new ArrayList(){{add("1");}};
        maps.put("a",l1);*/
        List<String> a = maps.computeIfAbsent("a", e -> new ArrayList<>());
//        a.add("2");
        System.out.println(maps.get("a"));
    }
}

package com.example.zdp.practice.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.zdp.practice.config.ScrewConfig;
import com.example.zdp.practice.service.IDistrictService;
import com.example.zdp.practice.service.freight.FreightRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName HelloController
 * @Author dongping
 * @Date 2020/8/18 15:48
 * @Description HelloController
 * @Version 1.0
 */
@Controller
public class HelloController {
    @Autowired
    StringRedisTemplate redisTemplates;
    @Autowired
    ScrewConfig screwConfig;

    @Autowired
    FreightRuleService freightRuleService;

    @Autowired
    IDistrictService iDistrictService;
    @Autowired
    ApplicationContext applicationContext;
  /*  @RequestMapping("/hello")
    public String hello(){
   *//*     String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
        screwConfig.documentGeneration("a",path);*//*

        return "html/a";
    }*/

    @GetMapping("/index")
    public String indexs(Model model){
        model.addAttribute("a","zdp");
        return "/aa";
    }

    @RequestMapping("/userAdd")
    @ResponseBody
    public String hello(){
        String key= "WLBJ"+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String s = redisTemplates.opsForValue().get(key);
        if(StringUtils.isEmpty(s)){
            s="1";
            redisTemplates.opsForValue().set(key,s,24, TimeUnit.HOURS);
        }else{
            s= new BigDecimal(s).add(BigDecimal.ONE).toPlainString();
        }
        String str = String.format("%04d", Integer.parseInt(s));
        String rule=key+str;
        System.out.println(rule);
        return rule;
    }

    @RequestMapping("/trans")
    @ResponseBody
    public String trans(){
       // applicationContext.publishEvent(new MyEvent(this,"我发不了一个测试事件"));
//        iDistrictService.processFreightRule();
//        freightRuleService.add();
        return "aaa";
    }


    class MyEvent extends ContextRefreshedEvent {

        private String message;


        public MyEvent(ApplicationContext source) {
            super(source);
        }

        public MyEvent(ApplicationContext source, String message) {
            super(source);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Component
    class MyLinstener implements ApplicationListener<ContextRefreshedEvent> {

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {

            System.out.println("shuaxin");
        }
    }
    @RequestMapping("/tt")
    @ResponseBody
    public String tt() throws Exception {
//        iDistrictService.processFreightRule();
        freightRuleService.insertNew();
        return "tt";
    }


    @RequestMapping("/query")
    @ResponseBody
    public String query() throws Exception {
//        iDistrictService.processFreightRule();
        return iDistrictService.queryOne();
    }

    @RequestMapping("/txTest")
    @ResponseBody
    public String txTest() throws Exception {
        freightRuleService.insert();
        return "yes";
    }


    @RequestMapping("/updateDistrict")
    @ResponseBody
    public String updateDistrict() throws Exception {
        iDistrictService.updateDistrict();
        return "yes";
    }
}

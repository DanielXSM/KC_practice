package com.example.zdp.practice.service.freight.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zdp.practice.bo.CheckAnimalBO;
import com.example.zdp.practice.bo.CheckPeopleBO;
import com.example.zdp.practice.dao.FreightRuleMapper;
import com.example.zdp.practice.po.FreightRulePO;
import com.example.zdp.practice.service.IDistrictService;
import com.example.zdp.practice.service.freight.FreightRuleService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dongping
 * @since 2020-09-09
 */
@Service
@Slf4j
public class FreightRuleServiceImpl extends ServiceImpl<FreightRuleMapper, FreightRulePO> implements FreightRuleService {
    @Autowired
    IDistrictService iDistrictService;


    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;


    @Override
    @Transactional(rollbackFor = {Exception.class,Error.class},propagation = Propagation.REQUIRES_NEW)
    public void add() {
        FreightRulePO freightRulePO=new FreightRulePO();
        freightRulePO.setUid("asdfghjksfdgvdgs");
        baseMapper.insert(freightRulePO);
        try {
            insertNew();
//            FreightRuleService bean = applicationContext.getBean(FreightRuleService.class);
        /*    FreightRuleServiceImpl currentProxy = (FreightRuleServiceImpl)AopContext.currentProxy();
            currentProxy.insertNew();*/
//            iDistrictService.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("cvcvvvvv");
    }


    @Override
    public void insertNew() throws Exception{
        //手动开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        FreightRulePO freightRulePO=new FreightRulePO();
        freightRulePO.setUid("999999");
        if(1==2){
            throw new RuntimeException("插入失败！");
        }
        baseMapper.insert(freightRulePO);
//        手动提交事务

        FreightRulePO freightRulePO1=new FreightRulePO();
        freightRulePO1.setUid("6666666");
        baseMapper.insert(freightRulePO1);
        System.out.println("手动提交");
//        dataSourceTransactionManager.commit(transactionStatus);//提交
        //最好是放在catch 里面,防止程序异常而事务一直卡在哪里未提交
        dataSourceTransactionManager.rollback(transactionStatus);
    }

    @Override
    @Transactional
    public void insert() {
        FreightRulePO freightRulePO=new FreightRulePO();
        freightRulePO.setUid("6666");
        baseMapper.insert(freightRulePO);
        try {
            if(1==1){
                throw new RuntimeException("插入失败！");
            }
        }catch (Throwable throwable){
            throwable.getStackTrace();
        }
        FreightRulePO freightRulePO1=new FreightRulePO();
        freightRulePO1.setUid("777");
        baseMapper.insert(freightRulePO1);
    }


    public static void main(String[] args) {
        String text="~AgAAAABxLRoIT9qzQwH8LTbS5WXbifW4RufAwZRUpqBFgbfvhqugvfCaIJtrp8IA+Hrh7CHoBOq6lGyYeMRC/8bQOEOPSuLhdmJknhS5xSakz16/4vlUAvfKvYpHVFK4y8muEj9MUTtS0M3XeE0zEg==~q9qLC3W/5VNbUkMfsiK8MBMoUiZZFnY0rBpC9Ik6Ab7Z3degdar8L/HuBUGN2U10vYpaBmJN03a+4PRsR/Cd~0~~";
        System.out.println(text.startsWith("~"));
   /*     say1();
        System.out.println("say2");*/
//        int a=1;
//        if(a==2){
//            System.out.println("第一次");
//        }else if(a==3){
//            System.out.println("第二次");
//        }else{
//            System.out.println("第三次");
//        }
  /*      CheckAnimalBO checkAnimalBO=new CheckAnimalBO();
        checkAnimalBO.setNo(false);
        CheckPeopleBO checkPeopleBO=new CheckPeopleBO();
        checkPeopleBO.setYes(true);
        System.out.println(checkAnimalBO.getNo().equals(checkPeopleBO.getYes()));*/
        System.out.println(UUID.randomUUID());
       /* String s = new String("abc");
        s = "cba";
        System.out.println(s);
        FreightRulePO freightRulePO=new FreightRulePO();
        freightRulePO.setUid("ad");
        String ac="12345";
        freightRulePO=doIt(freightRulePO);
        doString(ac);
        System.out.println(ac);
        System.out.println(freightRulePO.getUid());*/
    }
public static void say1(){
        if(1==1){
            return;
        }
    System.out.println("第一次请求");
}
    private static void doString(String ac) {
        ac=new String("54321");
    }

    private  static FreightRulePO doIt(FreightRulePO freightRulePO) {
        freightRulePO=new FreightRulePO();
        freightRulePO.setUid("ADD");
        System.out.println("无语"+freightRulePO);
        return freightRulePO;
    }


}

package com.example.zdp.practice.service.freight;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zdp.practice.po.FreightRulePO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongping
 * @since 2020-09-09
 */
public interface FreightRuleService extends IService<FreightRulePO> {


    void add();

    public void insertNew() throws Exception;

    void insert();
}

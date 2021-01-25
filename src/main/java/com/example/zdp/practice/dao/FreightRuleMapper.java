package com.example.zdp.practice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zdp.practice.po.FreightRulePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dongping
 * @since 2020-09-09
 */
@Mapper
public interface FreightRuleMapper extends BaseMapper<FreightRulePO> {

}

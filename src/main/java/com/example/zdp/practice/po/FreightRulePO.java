package com.example.zdp.practice.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 计费规则主表
 * </p>
 *
 * @author dongping
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FreightRulePo对象", description="")
@TableName(value = "freight_rule")
public class FreightRulePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "逻辑主键")
    private String uid;

    @ApiModelProperty(value = "规则编码，时间戳")
    private String ruleCode;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "规则编码版本号拼接")
    private String ruleCodeVersion;


    @ApiModelProperty(value = "物流组织编码")
    private String carrierOrgCode;

    @ApiModelProperty(value = "物流组织名称")
    private String carrierOrgName;

    @ApiModelProperty(value = "承运商code")
    private String carrierCode;

    @ApiModelProperty(value = "承运商的名称")
    private String carrierName;

    @ApiModelProperty(value = "运输方式 1：EXPRESS快递，2;ROAD_retail公路零担：3：ROAD_carload公路整车 4:road_mix公路零担、整车组合")
    private String shippingWayCode;

    @ApiModelProperty(value = "运输方式 1：EXPRESS快递，2;ROAD_SCATTERED公路零担：3：ROAD_VEHICLE公路整车")
    private String shippingWayName;

    @ApiModelProperty(value = "计价方式 1：SEQUEL_CALC首续重计价、2:UNIT_CALC单价计价、3:CHARTER_CALC包车计价")
    private String calcWayCode;

    @ApiModelProperty(value = "计价方式 1：SEQUEL_CALC首续重计价、2:UNIT_CALC单价计价、3:CHARTER_CALC包车计价")
    private String calcWayName;

    @ApiModelProperty(value = "规则类型，1;b_default默认规则 2：a_special特殊规则")
    private String ruleTypeCode;

    @ApiModelProperty(value = "规则类型，1;DEFAULT_RULE默认规则 2：SPECIAL_RULE特殊规则")
    private String ruleTypeName;

    @ApiModelProperty(value = "区间适用规则，1：LEFT_OFF左闭右开、2：LEFT_ON左开右闭")
    private String intervalApplyRuleCode;

    @ApiModelProperty(value = "区间适用规则，1：LEFT_OFF左闭右开、2：LEFT_ON左开右闭")
    private String intervalApplyRuleName;

    @ApiModelProperty(value = "规则状态,规则状态名字，3待启用，5待生效，6生效中，7已失效，8已作废")
    private String ruleStatusCode;

    @ApiModelProperty(value = "规则状态,规则状态名字，3待启用，5待生效，6生效中，7已失效，8已作废")
    private String ruleStatusName;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime ruleStartTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime ruleEndTime;

    @ApiModelProperty(value = "币种code")
    private String currencyCode;

    @ApiModelProperty(value = "币种的名字")
    private String currencyName;

    @ApiModelProperty(value = "运输车型code")
    private String shippingModelCode;

    @ApiModelProperty(value = "运输车型的名字运输车型；general普通车、refrigeration 冷冻车、hazardous 危险品车")
    private String shippingModelName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

/*    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;*/

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新人")
    private String updateBy;


}

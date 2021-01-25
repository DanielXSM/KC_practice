package com.example.zdp.practice.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ImportFreightRuleBO
 * @Author dongping
 * @Date 2020/11/30 21:31
 * @Description ImportFreightRuleBO
 * @Version 1.0
 */
@Data
public class ImportFreightRuleBO {
    @Excel(name = "承运商" )
    private String carrierName;
    @Excel(name = "规则类型")
    private String ruleStatus;
    @Excel(name = "目的地省")
    private String receiveProvince;
    @Excel(name = "目的地市")
    private String receiveCity;
    @Excel(name = "目的地区")
    private String receiveDistrict;
    @Excel(name = "适用业务")
    private String applyBusiness;
    @ExcelCollection(name="目的地信息")
    private List<ReceiveBO> receiveBOList;

    @ExcelCollection(name="适用区间")
    private List<PriceWayBO> priceWay;

}

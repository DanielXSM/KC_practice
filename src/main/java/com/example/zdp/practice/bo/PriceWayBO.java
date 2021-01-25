package com.example.zdp.practice.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @ClassName PriceWayBO
 * @Author dongping
 * @Date 2020/11/30 21:55
 * @Description PriceWayBO
 * @Version 1.0
 */
@Data
public class PriceWayBO {
    @Excel(name = "左区间")
    private String left;
    @Excel(name = "右区间")
    private String right;

    @Excel(name = "包车价")
    private String val;
}

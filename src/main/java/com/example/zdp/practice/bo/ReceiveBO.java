package com.example.zdp.practice.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName ReceiveBO
 * @Author dongping
 * @Date 2020/12/1 11:44
 * @Description ReceiveBO
 * @Version 1.0
 */
@Data
@Builder
public class ReceiveBO {

    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;

    @Excel(name = "区县")
    private String district;
}

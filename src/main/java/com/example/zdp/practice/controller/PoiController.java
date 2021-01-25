package com.example.zdp.practice.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.zdp.practice.bo.ImportFreightRuleBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName PoiController
 * @Author dongping
 * @Date 2020/11/30 21:25
 * @Description PoiController
 * @Version 1.0
 */
@RestController
public class PoiController {
    @PostMapping("/import")
    public void importExcel(@RequestParam("excel") MultipartFile excel)throws Exception{
        ImportParams params = new ImportParams();

        // 距离表头中间有几行不要的数据
        params.setHeadRows(2);

        // 表头在第几行
        params.setTitleRows(0);
        List<ImportFreightRuleBO> result = ExcelImportUtil.importExcel(excel.getInputStream(), ImportFreightRuleBO.class,params);
        for(ImportFreightRuleBO importFreightRuleBO:result){
            System.out.println(importFreightRuleBO.toString());
        }

    }
}

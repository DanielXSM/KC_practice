package com.example.zdp.practice.service;

import com.example.zdp.practice.dto.CityTreeVo;
import com.example.zdp.practice.po.District;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author carrey
 * @since 2020-08-27
 */
public interface IDistrictService extends IService<District> {

    public List<District> queryProvince();
    public List<District> queryCity();
    public List<District> queryArea();
    public  void showTree(List<CityTreeVo> list, int deep,StringBuffer sb);
    public List<CityTreeVo> packageArea();

    void add();
    void adds()throws Exception;
    public void processFreightRule();

    String queryOne();

    void updateDistrict();
}

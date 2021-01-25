package com.example.zdp.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName CityTreeVo
 * @Author dongping
 * @Date 2020/8/27 14:09
 * @Description CityTreeVo
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityTreeVo {
    private Integer parentId;
    private Integer id;
    private String name;
    private String code;
    private List<CityTreeVo> child;

}

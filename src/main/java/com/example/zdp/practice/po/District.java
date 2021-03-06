package com.example.zdp.practice.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author carrey
 * @since 2020-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="District对象", description="")
@ToString
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区划信息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父级挂接id")
    private Integer pid;

    @ApiModelProperty(value = "区划编码")
    private String code;

    @ApiModelProperty(value = "区划名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态 0 正常 -2 删除 -1 停用")
    private Boolean status;

    @ApiModelProperty(value = "级次id 0:省/自治区/直辖市 1:市级 2:县级")
    private Boolean level;


}

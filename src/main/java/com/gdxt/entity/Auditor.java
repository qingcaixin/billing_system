package com.gdxt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangXin
 * @Date 2023/6/14 10:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//审核人信息表
public class Auditor {
    private static final long serialVersionUID = 1L;
    private Long id;
    //审核人姓名
    private String name;
    //合同号
    private String contractNumber;
    //审核人手机号
    private String phone;
    //审核状态 0 拒绝 1 成功
    private Integer status;
    //审核人职位 0 经理 1 技术支持 2 售后
    private String position;
    //拒绝原因
    private String reason;
}

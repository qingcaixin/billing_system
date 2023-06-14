package com.gdxt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author WangXin
 * @Date 2023/6/14 10:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//合同信息表
public class Contract {
    private static final long serialVersionUID = 1L;
    private Long id;
    //合同名字
    private String name;
    //合同号
    private String number;
    //甲方名称
    private String masterName;
    //合同类型 0临时合同  1正式合同  2存量合同
    private Integer type;
    //合同存储路径
    private String path;
    //合同签订时间
    private LocalDateTime signTime;
    //合同到期时间
    private LocalDateTime expireTime;
    //审核状态 0 拒绝  1 成功
    private Integer reviewStatus;
    // 1启用 0停止 默认是启用1
    private Integer status;
}

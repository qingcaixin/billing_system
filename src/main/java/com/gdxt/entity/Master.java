package com.gdxt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangXin
 * @Date 2023/6/14 10:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//甲方信息表
public class Master {
    private static final long serialVersionUID = 1L;
    private Long id;
    //甲方名字
    private String name;
    //甲方手机号
    private String phone;
    //甲方地址
    private String address;
}

package com.gdxt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractQueryDto {
    //合同名字
    private String name;
    //甲方名称
    private String masterName;
    //合同号
    private String number;
}

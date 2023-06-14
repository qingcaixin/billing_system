package com.gdxt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author WangXin
 * @Date 2023/6/14 16:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpireContractDto {
    //合同号
    private String contractNumber;
    //甲方姓名
    private String masterName;
    //甲方手机号
    private String phone;
    //合同到期时间
    private LocalDateTime expireTime;
}

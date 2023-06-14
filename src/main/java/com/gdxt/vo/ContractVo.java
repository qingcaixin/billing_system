package com.gdxt.vo;

import com.gdxt.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractVo extends Contract implements Serializable {

    //合同到期时间
    private LocalDateTime expireTime;
}

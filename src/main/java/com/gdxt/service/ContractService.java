package com.gdxt.service;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.result.CommonResult;
import com.gdxt.vo.ContractVo;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:41
 * 合同相关接口
 */
public interface ContractService {

    /**
     * 查询到期时间
     * @param contractQueryDto
     * @return
     */
    ContractVo selectTime(ContractQueryDto contractQueryDto);
}

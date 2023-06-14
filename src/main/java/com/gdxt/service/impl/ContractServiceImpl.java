package com.gdxt.service.impl;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.mapper.ContractMapper;
import com.gdxt.result.CommonResult;
import com.gdxt.service.ContractService;
import com.gdxt.vo.ContractVo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:47
 */
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Override
    public ContractVo selectTime(ContractQueryDto contractQueryDto) {

        ContractVo contractVo = contractMapper.getExpireTime(contractQueryDto);
        return contractVo;
    }
}

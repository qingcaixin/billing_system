package com.gdxt.service.impl;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.mapper.ContractMapper;
import com.gdxt.result.CommonResult;
import com.gdxt.service.ContractService;
import com.gdxt.vo.ContractVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:47
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 查询合同到期时间
     * @param contractQueryDto
     * @return
     */
    @Override
    public ContractVo selectTime(ContractQueryDto contractQueryDto) {
        ContractVo contractVo = contractMapper.getExpireTime(contractQueryDto);
        return contractVo;
    }
}

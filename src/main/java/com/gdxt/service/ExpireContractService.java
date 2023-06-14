package com.gdxt.service;

import com.gdxt.dto.ExpireContractDto;

import java.util.List;

/**
 * @Author WangXin
 * @Date 2023/6/14 16:29
 */
public interface ExpireContractService {
    /**
     * 查询所有合同的过期时间
     * @return
     */
    List<ExpireContractDto> getAllExpireContract() throws Exception;

}

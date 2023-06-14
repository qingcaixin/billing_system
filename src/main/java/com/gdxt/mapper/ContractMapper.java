package com.gdxt.mapper;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.vo.ContractVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author WangXin
 * @Date 2023/6/14 11:48
 */
@Mapper
public interface ContractMapper {
    ContractVo getExpireTime(ContractQueryDto contractQueryDto);
}

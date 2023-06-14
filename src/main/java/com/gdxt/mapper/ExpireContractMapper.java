package com.gdxt.mapper;

import com.gdxt.dto.ExpireContractDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author WangXin
 * @Date 2023/6/14 16:03
 */
@Mapper
public interface ExpireContractMapper {
    List<ExpireContractDto> getAllExpireContract();
}

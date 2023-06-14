package com.gdxt.controller;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.result.CommonResult;
import com.gdxt.result.MessageConstant;
import com.gdxt.service.ContractService;
import com.gdxt.util.FileUtil;
import com.gdxt.vo.ContractVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * @Author WangXin
 * @Date 2023/6/13 15:57
 */

@RestController
@RequestMapping("/contract")
@Slf4j
@Api(tags = "合同相关接口")
public class ContractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    private ContractService contractService;

    /**
     * 上传文件api
     * @param uploadFiles
     * @param req
     * @return
     */
    @PostMapping("/upload")
    public CommonResult<String> upload(@RequestPart("files") MultipartFile[] uploadFiles, HttpServletRequest req){
        LOGGER.info("==========上传文件:{}===========",uploadFiles);
        FileUtil fileUtil = new FileUtil();
        ArrayList contractList = new ArrayList();
        try {
             contractList = fileUtil.uploadContract(uploadFiles, req);
        } catch (Exception e) {
            return CommonResult.error(MessageConstant.UPLOAD_FAILED);
         }
        System.out.println(contractList);
        return CommonResult.success(MessageConstant.UPLOAD_SUCCESS);
    }


    /**
     * 根据合同名字||甲方名字||合同号查询到期时间
     * @param contractQueryDto
     * @return
     */
    @PostMapping("/expiretime")
    public CommonResult<ContractVo> selectExpirationTime(@RequestBody ContractQueryDto contractQueryDto){
        LOGGER.info("=========contractQueryDto:{}============",contractQueryDto);
        ContractVo contractVo = contractService.selectTime(contractQueryDto);
        return CommonResult.success(contractVo);
    }

    /**
     * 合同到期停用，改变状态
     * @param contractNumber
     * @return
     */
    @GetMapping("/status")
    public CommonResult<String> updateStatus(String contractNumber){
        LOGGER.info("=========contractNumber:{}============",contractNumber);
        contractService.updateStatus(contractNumber);
        return CommonResult.success();
    }
}

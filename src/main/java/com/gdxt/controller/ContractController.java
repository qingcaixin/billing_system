package com.gdxt.controller;

import com.gdxt.dto.ContractQueryDto;
import com.gdxt.result.CommonResult;
import com.gdxt.result.MessageConstant;
import com.gdxt.util.FileUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/upload")
    public CommonResult<String> upload(@RequestPart("files") MultipartFile[] uploadFiles, HttpServletRequest req){
        log.info("==========上传文件===========",uploadFiles);
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
     * 根据合同名字||甲方名字||手机号查询合同到期时间
     * @param contractQueryDto
     * @return
     */
    public CommonResult<String> selectExpirationTime(@RequestBody ContractQueryDto contractQueryDto){
        return null;
    }
}

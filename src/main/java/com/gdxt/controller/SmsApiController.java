package com.gdxt.controller;

import com.gdxt.result.CommonResult;
import com.gdxt.service.SmsService;
import com.gdxt.service.impl.SmsServiceImpl;
import com.gdxt.util.RandomUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author WangXin
 * @Date 2023/6/14 10:13
 */
@RestController
@RequestMapping("/sms")
@Slf4j
@Api(tags = "短信相关接口")
public class SmsApiController {

    @Autowired
    private SmsService smsService;

    //发送短信验证码
    @GetMapping(value = "/send/{phone}")
    public CommonResult<String> code(@PathVariable String phone){
        if (StringUtils.isEmpty(phone)) return CommonResult.error("手机号不能为空");
        //生成四位验证码
        String code = RandomUtil.getFourBitRandom();//生成验证码的随机值
        HashMap<String, Object> param = new HashMap<>();
        param.put("code",code);
        boolean isSend = smsService.send(param, phone);
        if (isSend){
           return CommonResult.success();
        }
        return CommonResult.error("短信发送失败");
    }
}

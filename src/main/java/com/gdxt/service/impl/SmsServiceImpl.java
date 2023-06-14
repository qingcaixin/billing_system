package com.gdxt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.gdxt.service.SmsService;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author WangXin
 * @Date 2023/6/14 9:49
 */
@Service
public class SmsServiceImpl implements SmsService {
    /**
     * 发送短信验证码
     * @param param
     * @param phone
     * @return
     */
    @Override
    public boolean send(Map<String, Object> param, String phone) {
        if (StringUtils.isNullOrEmpty(phone)) return false;

        //节点和阿里云的密钥
        DefaultProfile profile = DefaultProfile.getProfile("default", "Q2AtKVxX1N3tOh3AWHHzXyx", "ZgmmX3vSlMF9GnxliXZrLxoD7053Hx");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);//手机号
        //todo  需要更改阿里云签名和code
        request.putQueryParameter("SignName", "阿里云短信测试");    //申请阿里云 签名名称（暂时用阿里云测试的）
        request.putQueryParameter("TemplateCode", "SMS_154950909"); //申请阿里云 模板code（用的也是阿里云测试的）
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        try {
            //向阿里云发送请求
            CommonResponse response = client.getCommonResponse(request);
            //todo 获取返回的数据等待入库
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

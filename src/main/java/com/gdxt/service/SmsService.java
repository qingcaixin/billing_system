package com.gdxt.service;

import java.util.Map;

/**
 * @Author WangXin
 * @Date 2023/6/14 9:48
 */
public interface SmsService {

    //发送验证码
    boolean send(Map<String, Object> param, String phone);

}

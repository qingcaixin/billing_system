package com.gdxt.service.impl;

import com.gdxt.dto.ExpireContractDto;
import com.gdxt.mapper.ExpireContractMapper;
import com.gdxt.service.ContractService;
import com.gdxt.service.ExpireContractService;
import com.gdxt.service.SmsService;
import com.gdxt.util.DateUtil;
import com.gdxt.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * @Author WangXin
 * @Date 2023/6/14 16:30
 */
@Service
public class ExpireContractServiceImpl implements ExpireContractService {
    @Autowired
    private ExpireContractMapper expireContractMapper;
    @Autowired
    private SmsService smsService;
    @Autowired
    private ContractService contractService;
    @Override
    public List<ExpireContractDto> getAllExpireContract() throws Exception {

        List<ExpireContractDto> allExpireContract = expireContractMapper.getAllExpireContract();
        for (ExpireContractDto expireContractDto : allExpireContract) {
            //获得过期时间
            String expireTime = expireContractDto.getExpireTime().toString();
            //获得当前的时间
            String nowTime = DateUtil.getNowTime();
            //计算时间差
            long distanceDays = DateUtil.getDistanceDays(nowTime, expireTime);
            //todo 处理时间差,产品定义,暂时设置为10
            /*
            *  1：如过时间小于10 发短信和企业微信进行通知
            *  2：如果时间小于 0 去暂停合同的状态
            * */
            if (distanceDays <= 10){
                //调用短信接口
                String phone = expireContractDto.getPhone();
                String code = RandomUtil.getFourBitRandom();//生成验证码的随机值
                HashMap<String, Object> param = new HashMap<>();
                param.put("code",code);
                //发送短信获得结果
                boolean isSend = smsService.send(param, phone);
                //发微信推送
            }

            if (distanceDays < 0){
                //合同到期 去暂停合同
                String contractNumber = expireContractDto.getContractNumber();
                contractService.updateStatus(contractNumber);
            }

        }
        return null;
    }
}

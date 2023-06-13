package com.gdxt.result;
import lombok.Data;
import java.io.Serializable;

/**
 * @Author wangxin
 * @Date 2023/6/13 11:28
 */

/**
 * 后端统一返回结果
 * @param <T>
 */
@Data
public class CommonResult<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> CommonResult<T> success() {
        CommonResult<T> r = new CommonResult<T>();
        r.code = 1;
        return r;
    }

    public static <T> CommonResult<T> success(T object) {
        CommonResult<T> r = new CommonResult<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> CommonResult<T> error(String msg) {
        CommonResult r = new CommonResult();
        r.msg = msg;
        r.code = 0;
        return r;
    }

}

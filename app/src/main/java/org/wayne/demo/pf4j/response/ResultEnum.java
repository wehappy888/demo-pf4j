package org.wayne.demo.pf4j.response;

import cn.hutool.core.util.NumberUtil;
import lombok.Getter;

/**
 * @author wayne
 * @version 1.0
 * @since 2022/4/12 16:33
 */
public enum ResultEnum {

    /**
     * 未知结果
     */
    NONE(-1, "unknown"),
    /**
     * 成功
     */
    OK(200, "success"),
    /**
     * 警告
     */
    ALERT(201, "alert"),
    /**
     * 服务器错误
     */
    ERROR(500, "error"),
    /**
     * 失败
     */
    FAIL(1000, "fail");

    @Getter
    private final Integer code;

    @Getter
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static ResultEnum selectByCode(int code) {
        ResultEnum[] values = ResultEnum.values();
        for (ResultEnum value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return NONE;
    }

    public static ResultEnum selectByCode(String code) {
        if (NumberUtil.isNumber(code)) {
            int intCode = Integer.parseInt(code);
            return selectByCode(intCode);
        }
        return NONE;
    }


}

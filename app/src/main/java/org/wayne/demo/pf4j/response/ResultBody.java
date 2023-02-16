package org.wayne.demo.pf4j.response;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wayne
 * @version 1.0
 * @since 2022/4/13 9:26
 */
@Data
@ApiModel("接口统一返回对象")
public class ResultBody implements Serializable {

    /**
     * 处理结果标识码
     */
    @ApiModelProperty(value = "处理码", example = "200")
    private int code;

    /**
     * 处理结果消息
     */
    @ApiModelProperty(value = "处理消息", example = "成功")
    private String message;

    /**
     * HTTP请求的路径信息,一般不需要自行赋值
     */
    @ApiModelProperty(value = "请求路径", example = "/api/v1.0/paging")
    private String path;

    /**
     * 需要返回的业务数据
     */
    @ApiModelProperty(value = "返回数据(JSON)",
            example = "{\"name\": \"wayne\",\"sex\":\"男\",\"age\": 20}")
    private Object data;

    /**
     * HTTP请求结果状态码,一般不需要自行赋值
     */
    @ApiModelProperty(value = "HTTP状态码", example = "200")
    private int httpStatus;

    /**
     * 返回的附加数据
     */
    @ApiModelProperty(value = "附加数据(JSON)",
            example = "{\"weather\": \"晴天\"}")
    private Map<String, Object> extra = new HashMap<>(0);

    /**
     * 返回服务器时间,一般不需要自行赋值
     */
    @ApiModelProperty(value = "服务器时间戳", example = "1577808000000")
    private long timestamp;


    @ApiModelProperty(hidden = true)
    public boolean isOk() {
        return this.code == ResultEnum.OK.getCode();
    }

    public ResultBody() {
        this.code = ResultEnum.OK.getCode();
        this.message = ResultEnum.OK.getMessage();
    }

    public ResultBody(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public ResultBody(String message) {
        this.code = ResultEnum.OK.getCode();
        this.message = message;
    }

    public ResultBody(ResultEnum resultEnum, String message) {
        this.code = resultEnum.getCode();
        this.message = message;
    }

    public ResultBody(int code, String msg) {
        this.code = code;
        this.message = msg;
    }


    public static ResultBody success() {
        return new ResultBody();
    }

    public static ResultBody success(Object data) {
        return new ResultBody(ResultEnum.OK).setData(data);
    }

    public static ResultBody success(String msg, Object data) {
        return new ResultBody(ResultEnum.OK.getCode(), msg).setData(data);
    }

    public static ResultBody failed() {
        return new ResultBody(ResultEnum.FAIL);
    }

    public static ResultBody failed(String msg) {
        return new ResultBody(ResultEnum.FAIL.getCode(), msg);
    }

    public static ResultBody failed(ResultEnum resultEnum) {
        return new ResultBody(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static ResultBody failed(ResultEnum resultEnum, String msg) {
        return new ResultBody(resultEnum.getCode(), msg);
    }

    public static ResultBody failed(int code, String msg) {
        return new ResultBody(code, msg);
    }

    public static ResultBody error() {
        return new ResultBody(ResultEnum.ERROR);
    }


    public ResultBody setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBody setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResultBody setData(Object data) {
        this.data = data;
        return this;
    }

    public ResultBody setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public ResultBody setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResultBody putExtra(String key, Object value) {
        if (this.extra == null) {
            this.extra = MapUtil.newHashMap();
        }
        this.extra.put(key, value);
        return this;
    }

    public ResultBody setPath(String path) {
        this.path = path;
        return this;
    }

    public ResultBody setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 将数据转为Json字符串
     *
     * @return 数据的Json字符串
     */
    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", data=" + data +
                ", extra=" + extra +
                ", timestamp=" + timestamp +
                '}';
    }
}

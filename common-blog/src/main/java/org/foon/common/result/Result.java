package org.foon.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description <返回结果封装>
 * @DATE 2020/9/25 14:34
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private Object data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode("200");
        result.setMsg("成功!");
        result.setData(data);
        return result;
    }
    public static Result success(String msg, Object data) {
        Result m = new Result();
        m.setCode("200");
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
    public static Result fail(String msg) {
        Result m = new Result();
        m.setCode("500");
        m.setData(null);
        m.setMsg(msg);
        return m;
    }
    public static Result fail(String msg, Object data) {
        Result m = new Result();
        m.setCode("500");
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
    public static Result fail(String code, String msg, Object data) {
        Result m = new Result();
        m.setCode(code);
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
}

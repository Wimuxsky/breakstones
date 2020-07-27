package com.wimux.breakstones.web.vo;

/**
 * @Author siqigang
 * @Date 2018/9/21 16:02
 */
public class ResultVO {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILURE = 500;

    private int code;

    private String msg;

    private Object data;

    public ResultVO() {
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Object data) {
        this.data = data;
        code = CODE_SUCCESS;
        msg = "success";
        if (null == data) {
            code = CODE_FAILURE;
            msg = "系统异常！";
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}

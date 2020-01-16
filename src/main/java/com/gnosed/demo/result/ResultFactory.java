package com.gnosed.demo.result;

import com.gnosed.demo.pojo.User;

/**
 * @Author Gnosed Lu
 * @Date 2020/1/16
 */
public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, "失败", null);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}

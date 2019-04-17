package com.hcjz.common.result;

public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}

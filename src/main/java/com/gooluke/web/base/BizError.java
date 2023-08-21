package com.gooluke.web.base;

/**
 * @author 咕噜科
 * ClassName: BizError
 * date: 2023-08-21 21:55
 * Description:
 * version 1.0
 */
public class BizError {

    private String errCode;
    private String errMsg;
    private String debugMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getDebugMsg() {
        return debugMsg;
    }

    public void setDebugMsg(String debugMsg) {
        this.debugMsg = debugMsg;
    }
}

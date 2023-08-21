package com.gooluke.web.base;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: BizErrors
 * date: 2023-08-21 21:55
 * Description:
 * version 1.0
 */
public class BizErrors {

    private List<BizError> bizErrors;

    private boolean hasErrors () {
        return bizErrors != null && bizErrors.size() > 0;
    }

    public List<BizError> getBizErrors() {
        return bizErrors;
    }

    public void setBizErrors(List<BizError> bizErrors) {
        this.bizErrors = bizErrors;
    }
}

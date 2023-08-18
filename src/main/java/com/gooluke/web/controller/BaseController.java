package com.gooluke.web.controller;

import com.gooluke.common.interfaces.TemplateInterface;
import com.gooluke.common.tool.JsonMapper;
import com.gooluke.common.utils.BizSeqUtil;
import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: BaseController
 * date: 2023-08-18 20:32
 * Description:
 * version 1.0
 */
public class BaseController {

    protected static final JsonMapper JSON_MAPPER = JsonMapper.nonEmptyMapper();

    @Autowired
    private BizSeqUtil bizSeqUtil;
    protected static long timeout = 7000;


    public <T extends BaseResponseDTO,E extends BaseRequestDTO> T doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, long timeout, E request, TemplateInterface<T,E> templateInterface){
        //TODO 执行逻辑
        setBizSeq(request);
        T response = templateInterface.apply(request);
        response.setBizSeqNo(request.getBizSeqNo());
        return response;
    }

    private <E extends BaseRequestDTO> void setBizSeq(E req) {
        if (req.getBizSeqNo() != null && req.getBizSeqNo().length() > 0) {
            return;
        }
        String bizSeqNo = bizSeqUtil.newBizSeq();
        req.setBizSeqNo(bizSeqNo);
    }
}

package com.gooluke.web.controller;

import com.gooluke.common.utils.CoreHttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author 咕噜科
 * ClassName: TestController
 * date: 2023-06-10 15:53
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CoreHttpUtils httpUtils;

    @RequestMapping("/http")
    public String testHttp() {
        return "hello,this is admin!";
    }

    /**
     * deferredResult 延迟返回测试
     */
    @RequestMapping("/deferredResult")
    public DeferredResult<String> testDeferredResult() {
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L,"Hello World");
        new Thread(() -> {
            try {
                Thread.sleep(7000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deferredResult.setResult("okk");
        }).start();
        return deferredResult;
    }
}

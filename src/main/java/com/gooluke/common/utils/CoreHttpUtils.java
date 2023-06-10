package com.gooluke.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @author 咕噜科
 * ClassName: CoreHttpUtils
 * date: 2023-06-10 15:39
 * Description:
 * version 1.0
 */
@Component
public class CoreHttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(CoreHttpUtils.class);

    private RestTemplate restTemplate;
    private HttpHeaders header;

    @PostConstruct
    public void init() {
        initHeader();
        initRestTemplate();
    }

    private void initRestTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setReadTimeout(8000);
        requestFactory.setConnectTimeout(8000);
        restTemplate = new RestTemplate(requestFactory);
        logger.info("---initRestTemplate finish...---");
    }

    private void initHeader() {
        header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        logger.info("---initHeader finish...---");
    }

    public Object postForObject (String url,String request,Class<?> clazz) {
        HttpEntity<String> entity = new HttpEntity<>(request,header);
        return restTemplate.postForObject(url,entity,clazz);
    }

    public Object getForObject (String url,String request,Class<?> clazz) {
        HttpEntity<String> entity = new HttpEntity<>(request,header);
        return restTemplate.getForObject(url,clazz,entity);
    }
}

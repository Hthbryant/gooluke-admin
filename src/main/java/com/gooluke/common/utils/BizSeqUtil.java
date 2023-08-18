package com.gooluke.common.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 咕噜科
 * ClassName: BizSeqUtil
 * date: 2023-08-18 21:30
 * Description:
 * version 1.0
 */
@Component
public class BizSeqUtil {

    private final static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

    public String newBizSeq() {
        String dateStr = yyyyMMddHHmmss.format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        String date = dateStr.substring(0, 8);
        char[] timeArray = dateStr.substring(8).toCharArray();
        stringBuilder.append(date);
        for (int i = 0; i < 6; i++) {
            int random = (int)(Math.random() * 10);
            stringBuilder.append(random);
            stringBuilder.append(timeArray[i]);
        }
        return stringBuilder.toString();
    }

}

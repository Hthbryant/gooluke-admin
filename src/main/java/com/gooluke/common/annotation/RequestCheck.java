package com.gooluke.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 咕噜科
 * ClassName: RequestCheck
 * date: 2023-08-18 20:29
 * Description:
 * version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequestCheck {
}

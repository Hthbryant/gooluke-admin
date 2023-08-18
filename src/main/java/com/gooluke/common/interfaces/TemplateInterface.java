package com.gooluke.common.interfaces;

/**
 * @author 咕噜科
 * ClassName: TemplateInterface
 * date: 2023-08-18 20:33
 * Description:
 * version 1.0
 */
@FunctionalInterface
public interface TemplateInterface<T , E> {

    T apply(E r);

}

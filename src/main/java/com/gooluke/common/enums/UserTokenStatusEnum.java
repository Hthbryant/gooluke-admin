package com.gooluke.common.enums;

/**
 * @author 咕噜科
 * ClassName: UserTokenStatusEnum
 * date: 2023-08-21 1:11
 * Description:
 * version 1.0
 */
public enum UserTokenStatusEnum {

    NORMAL("normal","正常"),
    LOCKED("locked","锁定"),
    DELETED("deleted","删除");

    UserTokenStatusEnum(String status,String desc){
        this.status = status;
        this.desc = desc;
    }

    private String status;
    private String desc;

    public String getStatus() {
        return status;
    }
    public String getDesc() {
        return desc;
    }
}

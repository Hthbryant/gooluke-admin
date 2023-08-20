CREATE TABLE `t_user_info` (
    `id` int(11) not null AUTO_INCREMENT COMMENT 'id',
    `user_id` VARCHAR(30) NOT NULL COMMENT '用户id',
    `user_name` VARCHAR(30) NOT NULL COMMENT '用户名',
    `nick_name` VARCHAR(30) NOT NULL COMMENT '昵称',
    `password` VARCHAR(64) NOT NULL COMMENT '密码',
    `address` VARCHAR(100) NOT NULL COMMENT '地址',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE KEY idx_user_id (user_id) USING BTREE
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户信息表';
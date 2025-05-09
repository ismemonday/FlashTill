CREATE DATABASE IF NOT EXISTS flash_till DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
USE flash_till;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `ft_seat`
(
  `id`             int(10) unsigned                 NOT NULL AUTO_INCREMENT,
  `shop_id`        int(10) unsigned                 NOT NULL COMMENT '店铺id',
  `seat_name`      varchar(128)                     NOT NULL DEFAULT '' COMMENT '名称',
  `seat_state`     varchar(128)                     NOT NULL DEFAULT '' COMMENT '席位状态, 空闲, 占用, 停用',
  PRIMARY KEY (`id`),
  UNION_KEY `idx_shop_id_name` (`shop_id`, `seat_name`) USING BTREE COMMENT 'seat唯一'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='席位';

CREATE TABLE `ft_order`
(
  `id`             int(10) unsigned                 NOT NULL AUTO_INCREMENT,
  `shop_id`        int(10) unsigned                 NOT NULL COMMENT '店铺id',
  `seat_id`        int(10) unsigned                 NOT NULL COMMENT '席位id',
  `dish_id`        int(10) unsigned                 NOT NULL COMMENT '菜品id ,
  `order_type`     varchar(128)                     NOT NULL DEFAULT '' COMMENT '订单类型, 点菜, 退菜',
  `create_time`    datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`    datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNION_KEY `idx_shop_seat_dish` (`shop_id`, `seat_id`,`dish_id`) USING BTREE COMMENT 'order唯一'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='订单';

CREATE TABLE `ft_dish`
(
  `id`             int(10) unsigned                 NOT NULL AUTO_INCREMENT,
  `shop_id`        int(10) unsigned                 NOT NULL COMMENT '店铺id',
  `dish_name`           varchar(128)                NOT NULL DEFAULT '' COMMENT '菜名',
  `category`       varchar(128)                     NOT NULL DEFAULT '' COMMENT '类别:主菜，酒水,茶位',
  `in_price`       decimal(10, 2)                   NOT NULL DEFAULT '0.00' COMMENT '进价',
  `out_price`      decimal(10, 2)                   NOT NULL DEFAULT '0.00' COMMENT '售价',
  `des`            varchar(512)                     NOT NULL DEFAULT '' COMMENT '描述',
  `img`            BLOB                             NOT NULL COMMENT '图片',
  PRIMARY KEY (`id`),
  KEY `idx_shop_id` (`shop_id`) USING BTREE,
  UNION_KEY `idx_shop_id_name` (`shop_id`, `dish_name`) USING BTREE COMMENT 'dish的唯一'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='dish';

  CREATE TABLE `ft_shop`
  (
    `id`             int(10) unsigned                 NOT NULL AUTO_INCREMENT,
    `name`           varchar(128)                     NOT NULL DEFAULT '' COMMENT '店名',
    `location`       varchar(512)                     NOT NULL DEFAULT '' COMMENT '位置,
    `boss_name`      varchar(128)                     NOT NULL DEFAULT '' COMMENT '店长名字',
    `boss_phone`     varchar(128)                     NOT NULL DEFAULT '' COMMENT '店长电话',
    `license_img`       LONG_BLOB                     NOT NULL COMMENT '营业执照图片`,
    `id_card_back_img`  LONG_BLOB                     NOT NULL COMMENT '身份证反面图片`,
    `id_card_front_img` LONG_BLOB                     NOT NULL COMMENT '身份证正面图片`,
    `bank_name`      varchar(128)                     NOT NULL DEFAULT '' COMMENT '开户行`,
    `bank_account`   varchar(128)                     NOT NULL DEFAULT '' COMMENT '银行账号`,
    `shop_state`     varchar(128)                     NOT NULL DEFAULT '' COMMENT '店状态, 审核中，正常, 停业, 注销`
    `create_time`    datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_phone` (`boss_phone`) USING BTREE
  ) ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT ='shop';

CREATE TABLE IF NOT EXISTS `ft_rbac_user`
(
    `id`           INT(11)      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username`     VARCHAR(64)  NOT NULL COMMENT '用户名称',
    `phone_num`    VARCHAR(128) NOT NULL COMMENT  '手机号',
    `password`     VARCHAR(64)  NOT NULL COMMENT '密码',
    `icon`         BLOB                  COMMENT '头像',
    `email`        VARCHAR(128) NOT NULL DEFAULT '' COMMENT '邮箱',
    `note`         VARCHAR(512) NOT NULL DEFAULT '' COMMENT '备注信息',
    `account_enable`       VARCHAR(12)   COMMENT '帐号启用状态：禁用,启用',
    `created_by`   VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建用户',
    `modified_by`  VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新用户',
    `gmt_create`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_phone_num` (`phone_num`) USING BTREE COMMENT '手机号'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户表';


CREATE TABLE IF NOT EXISTS `ft_rbac_role`
(
    `id`                       INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_name`                VARCHAR(64) NOT NULL COMMENT '角色名称',
    `account_enable`           VARCHAR(12)   COMMENT '帐号启用状态：禁用,启用',
    `created_by`               VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建用户',
    `modified_by`              VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新用户',
    `gmt_create`               DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`             DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

INSERT INTO `ft_rbac_role` (`role_name`) VALUES ('mm');
INSERT INTO `ft_rbac_role` (`role_name`) VALUES ('boss');
INSERT INTO `ft_rbac_role` (`role_name`) VALUES ('staff');
INSERT INTO `ft_rbac_role` (`role_name`) VALUES ('interview');

CREATE TABLE IF NOT EXISTS `ft_rbac_user_role_relation`
(
    `id`                       INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`                  INT NOT NULL DEFAULT 0 COMMENT '用户ID',
    `role_id`                  INT NOT NULL DEFAULT 0 COMMENT '角色ID',
    `gmt_create`               DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`             DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_user_role` (`user_id`, `role_id`) USING BTREE COMMENT '名称唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户-角色关系表';

CREATE TABLE IF NOT EXISTS ft_shop_user_relation;
(
    id                       INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    user_id                  INT NOT NULL DEFAULT 0 COMMENT '用户ID',
    shop_id                  INT NOT NULL DEFAULT 0 COMMENT '店铺ID',
    gmt_create               DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified             DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uni_user_shop (user_id, shop_id) USING BTREE COMMENT '名称唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户-店铺关系表';


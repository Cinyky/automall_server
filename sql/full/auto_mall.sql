-- 车
CREATE TABLE `car`
(
  `id`              varchar(255) NOT NULL DEFAULT '' COMMENT '商品ID',
  `title`           varchar(1024)         DEFAULT NULL COMMENT '商品名称',
  `description`     varchar(2048)         DEFAULT NULL COMMENT '商品描述',
  `band`            varchar(255)          DEFAULT NULL COMMENT '品牌',
  `mark`            varchar(255)          DEFAULT NULL COMMENT '型号',
  `config`          varchar(2048)         DEFAULT NULL COMMENT '配置',
  `reg_time`        varchar(255)          DEFAULT NULL COMMENT '上牌时间',
  `insurance_time`  varchar(255)          DEFAULT NULL COMMENT '保险时间',
  `check_time`      varchar(255)          DEFAULT NULL COMMENT '验车时间',
  `transfer_num`    int(10)               DEFAULT NULL COMMENT '过户次数',
  `output_volume`   float(10, 0)          DEFAULT NULL COMMENT '汽车排量',
  `distance`        int(10)               DEFAULT NULL COMMENT '行驶里程',
  `price`           float(10, 0)          DEFAULT NULL COMMENT '价格',
  `output_standard` varchar(255)          DEFAULT NULL COMMENT '汽车排放标准',
  `color`           varchar(255)          DEFAULT NULL COMMENT '车身颜色',
  `model`           int(10)               DEFAULT '0' COMMENT '手动自动 默认手动 0',
  `status`          int(10)               DEFAULT '0' COMMENT '初始化状态',
  `create_time`     bigint(20)            DEFAULT '0' COMMENT '创建时间',
  `update_time`     bigint(20)            DEFAULT NULL COMMENT 'updateTime',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 车图
CREATE TABLE `car_image`
(
  `id`       varchar(255) NOT NULL DEFAULT '' COMMENT '图片ID',
  `car_id`   varchar(255)          DEFAULT NULL COMMENT '商品名称',
  `image_id` varchar(255)          DEFAULT NULL COMMENT '图片Id',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 商家信息
CREATE TABLE `shop`
(
  `id`          varchar(255) NOT NULL DEFAULT '' COMMENT '商家ID',
  `name`        varchar(1024)         DEFAULT NULL COMMENT '商品名称',
  `description` varchar(2048)         DEFAULT NULL COMMENT '商家描述',
  `tel`         varchar(255)          DEFAULT NULL COMMENT '电话',
  `wechat`      varchar(255)          DEFAULT NULL COMMENT '微信',
  `banner`      varchar(2048)         DEFAULT NULL COMMENT '广告图',
  `location`    varchar(255)          DEFAULT NULL COMMENT '地理位置',
  `longitude`   varchar(255)          DEFAULT NULL COMMENT '经度',
  `latitude`    varchar(255)          DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
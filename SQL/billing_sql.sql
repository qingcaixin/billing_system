create table contract
(
    id          bigint auto_increment comment '主键'
        primary key,
    name        varchar(50)    null comment '合同名字',
    number        varchar(50)    null comment '合同号',
    master_name varchar(50)    null comment '甲方名字',
    type        tinyint(1)   not null comment  '合同类型 0临时合同  1正式合同  2存量合同',
    path       varchar(100)    null comment '存储路径',
    sign_time datetime       null comment '合同签订时间',
    expire_time datetime    null comment '合同到期时间',
    review_status        tinyint(1)   not null comment  '审核状态 0 拒绝  1 成功',
    status        tinyint(1)  default 1 not null comment  '1启用 0停止 默认是启用1'
)
    comment '合同信息表' collate = utf8_bin;

create table master
(
    id              bigint auto_increment comment '主键'
        primary key,
    name            varchar(50) null comment '甲方名字',
    contract_number varchar(50) null comment '合同号',
    phone           varchar(50) null comment '甲方手机号',
    address         varchar(50) null comment '甲方地址'

)
    comment '甲方信息表' collate = utf8_bin;
use shixunapp;

drop table if exists user_donate;
create table shixunapp.user_donate
(
    id           bigint auto_increment comment 'id'
        primary key,
    id int NOT NULL AUTO_INCREMENT,
    donateUserId bigint NOT NULL COMMENT '捐助用户的id',
    receiveUserId bigint NOT NULL COMMENT '接收捐助用户id',
    donateMoney int NULL DEFAULT 0 COMMENT '捐助的钱财',
    donateThing varchar(255)  NULL DEFAULT NULL COMMENT '捐助的物品（json表示）',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
)
    comment '用户-捐助表' collate = utf8mb4_unicode_ci;





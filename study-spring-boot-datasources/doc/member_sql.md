<!--------------------------------------创建会员数据库------------------------------------->
create database `db_member`;
use db_member;
create table `t_member_user`(
    `id` tinyint(4) not null auto_increment comment '主键',
    `name` varchar(32) default null comment '会员名',
    `age` tinyint(4) default null comment '会员年龄',
    primary key(id)
)engine=InnoDB charset=utf8 comment '会员信息表';

/***************************************************************/
/******      DKSCM(DK Supply Chain Management) MySQL      ******/
/***************************************************************/
-- 创建并使用数据库：dkscm_db
drop database if exists dkscm_db;
create database dkscm_db character set 'utf8mb4';
use dkscm_db;

-- 系统状态表：sys_status
drop table if exists sys_status;
create table sys_status(
	status_id int(10) not null auto_increment comment '状态主键',
	status_code varchar(100) not null comment '状态编码',
	status_text varchar(100) not null comment '状态文本',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(status_id)
)Engine=InnoDB charset='utf8mb4' comment='系统状态表';
insert into sys_status(status_code, status_text) values('ENABLE', '启用');
insert into sys_status(status_code, status_text) values('DISABLE', '禁用');
insert into sys_status(status_code, status_text) values('APPLY', '已申请，未购买审批');
insert into sys_status(status_code, status_text) values('RESCIND', '已撤销');
insert into sys_status(status_code, status_text) values('REVIEW', '已购买审批，未采购');
insert into sys_status(status_code, status_text) values('PURCHASE', '已采购，未入库审批');
insert into sys_status(status_code, status_text) values('STORE_REVIEW', '已采购，未入库审批');
insert into sys_status(status_code, status_text) values('STORE', '已入库，未领取');
insert into sys_status(status_code, status_text) values('RECEIVE', '已领取');
insert into sys_status(status_code, status_text) values('REVIEW_BACK', '购买审批驳回');
insert into sys_status(status_code, status_text) values('STORE_BACK', '入库审批驳回');
insert into sys_status(status_code, status_text) values('APPLY_BACK', '申请驳回');

-- 角色信息表：sys_role
drop table if exists sys_role;
create table sys_role(
	role_id int(10) not null auto_increment comment '角色主键',
	role_name varchar(255) not null comment '角色名称',
	status_code varchar(100) not null comment '状态编码',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(role_id)
)Engine=InnoDB charset='utf8mb4' comment='角色信息表';
insert into sys_role(role_name, status_code) values('超级管理员', 'ENABLE');
insert into sys_role(role_name, status_code) values('物资员', 'ENABLE');
insert into sys_role(role_name, status_code) values('总经理', 'ENABLE');
insert into sys_role(role_name, status_code) values('采购科', 'ENABLE');
insert into sys_role(role_name, status_code) values('仓库科', 'ENABLE');

-- 菜单信息表：sys_menu
drop table if exists sys_menu;
create table sys_menu(
	menu_id int(10) not null auto_increment comment '菜单主键',
	parent_id int(10) not null comment '上级菜单',
	menu_text varchar(255) not null comment '菜单文本',
	menu_url varchar(255) not null comment '链接地址',
	menu_icon varchar(255) not null comment '菜单图标',
	sort_order int(3) not null comment '排序',
	status_code varchar(100) not null comment '状态编码',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(menu_id)
)Engine=InnoDB charset='utf8mb4' comment='菜单信息表';
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(0, '系统管理', '', 'fa fa-tachometer', 1, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(0, '物资采购', '', 'fa fa-truck', 2, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(0, '历史采购', '', 'fa fa-calendar', 3, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(1, '系统用户', 'user/index', 'fa fa-users', 4, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(1, '角色管理', 'role/index', 'fa fa-hand-rock-o', 5, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(1, '我的信息', 'user/detail', 'fa fa-user', 6, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '采购申请', 'purchase/APPLY/index', 'fa fa-hand-paper-o', 7, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '采购审批', 'purchase/APPLY/index', 'fa fa-pencil-square-o', 8, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '物资购买', 'purchase/REVIEW/index', 'fa fa-cart-plus', 9, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '入库审批', 'purchase/PURCHASE/index', 'fa fa-pencil-square-o', 10, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '物资入库', 'purchase/STORE_REVIEW/index', 'fa fa-building-o', 11, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(2, '物资领取', 'purchase/STORE/index', 'fa fa-shopping-basket', 12, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(3, '已领取采购', 'purchase/RECEIVE/index', 'fa fa-sign-language', 13, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(3, '已申请驳回采购', 'purchase/REIVEW_BACK/index', 'fa fa-reply', 14, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(3, '已入库驳回采购', 'purchase/STORE_BACK/index', 'fa fa-reply', 15, 'ENABLE');
insert into sys_menu(parent_id, menu_text, menu_url, menu_icon, sort_order, status_code) values(3, '已撤回申请', 'purchase/APPLY_BACK/index', 'fa fa-reply', 15, 'ENABLE');

-- 角色菜单中间表：sys_role_menu
drop table if exists sys_role_menu;
create table sys_role_menu(
	role_id int(10) not null comment '角色主键',
	menu_id int(10) not null comment '菜单主键'
)Engine=InnoDB charset='utf8mb4' comment='角色菜单中间表';
insert into sys_role_menu(role_id, menu_id) values(1, 1);
insert into sys_role_menu(role_id, menu_id) values(1, 2);
insert into sys_role_menu(role_id, menu_id) values(1, 3);
insert into sys_role_menu(role_id, menu_id) values(1, 4);
insert into sys_role_menu(role_id, menu_id) values(1, 5);
insert into sys_role_menu(role_id, menu_id) values(1, 6);
insert into sys_role_menu(role_id, menu_id) values(1, 7);
insert into sys_role_menu(role_id, menu_id) values(1, 8);
insert into sys_role_menu(role_id, menu_id) values(1, 9);
insert into sys_role_menu(role_id, menu_id) values(1, 10);
insert into sys_role_menu(role_id, menu_id) values(1, 11);
insert into sys_role_menu(role_id, menu_id) values(1, 12);
insert into sys_role_menu(role_id, menu_id) values(1, 13);
insert into sys_role_menu(role_id, menu_id) values(1, 14);
insert into sys_role_menu(role_id, menu_id) values(1, 15);
insert into sys_role_menu(role_id, menu_id) values(1, 16);
insert into sys_role_menu(role_id, menu_id) values(2, 1);
insert into sys_role_menu(role_id, menu_id) values(2, 2);
insert into sys_role_menu(role_id, menu_id) values(2, 3);
insert into sys_role_menu(role_id, menu_id) values(2, 6);
insert into sys_role_menu(role_id, menu_id) values(2, 7);
insert into sys_role_menu(role_id, menu_id) values(2, 12);
insert into sys_role_menu(role_id, menu_id) values(2, 13);
insert into sys_role_menu(role_id, menu_id) values(2, 14);
insert into sys_role_menu(role_id, menu_id) values(2, 15);
insert into sys_role_menu(role_id, menu_id) values(2, 16);
insert into sys_role_menu(role_id, menu_id) values(3, 1);
insert into sys_role_menu(role_id, menu_id) values(3, 2);
insert into sys_role_menu(role_id, menu_id) values(3, 3);
insert into sys_role_menu(role_id, menu_id) values(3, 6);
insert into sys_role_menu(role_id, menu_id) values(3, 8);
insert into sys_role_menu(role_id, menu_id) values(3, 10);
insert into sys_role_menu(role_id, menu_id) values(3, 13);
insert into sys_role_menu(role_id, menu_id) values(3, 14);
insert into sys_role_menu(role_id, menu_id) values(3, 15);
insert into sys_role_menu(role_id, menu_id) values(3, 16);
insert into sys_role_menu(role_id, menu_id) values(4, 1);
insert into sys_role_menu(role_id, menu_id) values(4, 2);
insert into sys_role_menu(role_id, menu_id) values(4, 3);
insert into sys_role_menu(role_id, menu_id) values(4, 6);
insert into sys_role_menu(role_id, menu_id) values(4, 9);
insert into sys_role_menu(role_id, menu_id) values(4, 13);
insert into sys_role_menu(role_id, menu_id) values(4, 14);
insert into sys_role_menu(role_id, menu_id) values(4, 15);
insert into sys_role_menu(role_id, menu_id) values(4, 16);
insert into sys_role_menu(role_id, menu_id) values(5, 1);
insert into sys_role_menu(role_id, menu_id) values(5, 2);
insert into sys_role_menu(role_id, menu_id) values(5, 3);
insert into sys_role_menu(role_id, menu_id) values(5, 6);
insert into sys_role_menu(role_id, menu_id) values(5, 11);
insert into sys_role_menu(role_id, menu_id) values(5, 13);
insert into sys_role_menu(role_id, menu_id) values(5, 14);
insert into sys_role_menu(role_id, menu_id) values(5, 15);
insert into sys_role_menu(role_id, menu_id) values(5, 16);

-- 用户信息表：sys_user
drop table if exists sys_user;
create table sys_user(
	user_id int(10) not null auto_increment comment '用户主键',
	user_no varchar(100) comment '用户编码',
	username varchar(255) not null comment '用户姓名',
	cellphone varchar(100) not null comment '手机号码',
	password varchar(500) not null comment '登录密码',
	role_id int(10) not null comment '角色',
	id_card varchar(100) not null comment '身份证号码',
	email varchar(500) not null comment '电子邮件',
	user_photo varchar(500) comment '头像',
	status_code varchar(100) not null comment '状态编码',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
	primary key(user_id)
)Engine=InnoDB charset='utf8mb4' comment='用户信息表';
insert into sys_user(user_no, username, cellphone, password, role_id, id_card, email, status_code) values('DK000001', '王铁锤', '17629039600', '21232f297a57a5a743894a0e4a801fc3', 1, '', '', 'ENABLE');
insert into sys_user(user_no, username, cellphone, password, role_id, id_card, email, status_code) values('DK000002', '赵文强', '18149335896', 'ec2986eab15fbd349bb89d952952f14d', 2, '', '', 'ENABLE');
insert into sys_user(user_no, username, cellphone, password, role_id, id_card, email, status_code) values('DK000003', '易孝涛', '18691598057', 'a8c922ce25a46698afbb952aae62c85d', 3, '', '', 'ENABLE');
insert into sys_user(user_no, username, cellphone, password, role_id, id_card, email, status_code) values('DK000004', '康虎', '15592309275', 'b8b61970d8772a59001f133fe2322f63', 4, '', '', 'ENABLE');
insert into sys_user(user_no, username, cellphone, password, role_id, id_card, email, status_code) values('DK000005', '成博', '15771712836', '1f5f72f9d38b9cff1e5a663782ad26ac', 5, '', '', 'ENABLE');

-- 采购信息表：sys_purchase
drop table if exists sys_purchase;
create table sys_purchase(
	purchase_id int(10) not null auto_increment comment '采购主键',
	purchase_no varchar(100) comment '采购编码',
	goods_name varchar(500) not null comment '物资名称',
	goods_band varchar(500) not null comment '物资品牌',
	goods_type varchar(500) not null comment '物资型号',
	apply_quantity decimal(10, 2) not null comment '申请数量',
	goods_unit varchar(50) not null comment '单位',
	budget decimal(10, 2) not null comment '采购预算',
	apply_remark varchar(500) not null comment '申请备注',
	applicant_id int(10) not null comment '申请人',
	apply_time timestamp not null comment '申请时间',
	reviewer_id int(10) comment '申请审批人',
	review_remark varchar(500) comment '申请审批意见',
	review_time timestamp comment '申请审批时间', 
	purchaser_id int(10) comment '采购人',
	purchase_band varchar(500) comment '采购品牌',
	purchase_type varchar(500) comment '采购型号',
	purchase_quantity decimal(10, 2) comment '采购数量',
	purchase_amount decimal(10, 2) comment '采购金额',
	purchase_remark varchar(500) comment '采购备注',
	purchase_time timestamp comment '采购时间',
	store_reviewer_id int(10) comment '入库审批人',
	store_review_remark varchar(500) comment '入库审批备注',
	store_review_time timestamp comment '入库审批时间',
	storeman int(10) comment '入库人',
	store_remark varchar(500) comment '入库备注',
	store_time timestamp comment '入库时间',
	receiver_id int(10) comment '领取人',
	receiver_remark varchar(500) comment '领取备注',
	receive_time timestamp comment '领取时间',
	status_code varchar(100) not null comment '状态编码',
	create_time timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
	primary key(purchase_id)
)Engine=InnoDB charset='utf8mb4' comment='采购信息表';
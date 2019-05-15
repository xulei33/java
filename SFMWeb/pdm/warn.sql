SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS alert_status_stage;
DROP TABLE IF EXISTS sfm_alert;
DROP TABLE IF EXISTS sfm_trans;




/* Create Tables */

-- alert_status_stage
CREATE TABLE alert_status_stage
(
	alert_id int unsigned NOT NULL COMMENT '报警唯一标记',
	CMX_TRAN_ID int unsigned NOT NULL COMMENT '交易编号',
	-- 企业/部分标识
	multi_org_id varchar(64) COMMENT '机构号',
	alert_value varchar(100) COMMENT '报警值',
	-- 报警重新打开一次则加1
	alert_version_nbr tinyint unsigned COMMENT '报警版本号',
	init_smh_acct_type varchar(2) COMMENT 'init_smh_acct_type',
	init_smh_activity_type varchar(2) COMMENT 'init_smh_activity_type',
	-- active, closed, checkout
	alert_status char(10) COMMENT '报警状态',
	checkout_time timestamp COMMENT '取数时间戳',
	PRIMARY KEY (alert_id),
	UNIQUE (alert_id),
	UNIQUE (CMX_TRAN_ID)
) COMMENT = 'alert_status_stage';


-- 告警信息
CREATE TABLE sfm_alert
(
	alert_id int unsigned NOT NULL COMMENT '报警唯一标记',
	CMX_TRAN_ID int unsigned NOT NULL COMMENT '交易编号',
	-- 企业/部分标识
	multi_org_id varchar(64) COMMENT '机构号',
	user_id varchar(30) COMMENT '操作员编号',
	alert_value varchar(100) COMMENT '报警值',
	-- 报警重新打开一次则加1
	alert_version_nbr tinyint unsigned COMMENT '报警版本号',
	-- active, closed, checkout
	alert_status char(10) COMMENT '报警状态',
	init_smh_acct_type varchar(2) COMMENT 'init_smh_acct_type',
	init_smh_activity_type varchar(2) COMMENT 'init_smh_activity_type',
	PRIMARY KEY (alert_id),
	UNIQUE (alert_id)
) COMMENT = '告警信息';


-- 卡交易信息表
CREATE TABLE sfm_trans
(
	CMX_TRAN_ID int unsigned NOT NULL COMMENT '交易编号',
	XQO_CUST_NUM varchar(50) COMMENT '客户号',
	-- B: Busines, C:Corporation
	xqo_cust_type varchar(1) COMMENT '客户类型',
	XQO_CUST_NAME varchar(40) COMMENT '客户名称',
	XQO_LIMIT_AMT decimal COMMENT '限额',
	XQO_CUST_CNTRY_CODE varchar(3) COMMENT '客户国家代码',
	RUA_20BYTE_STRING_001 varchar(30) COMMENT '证件号码',
	rua_20byte_string_002 varchar(30) COMMENT '工作电话号码',
	RUA_20BYTE_STRING_003 varchar(30) COMMENT '移动电话号码',
	rua_20byte_string_004 varchar(30) COMMENT '邮箱地址',
	CMX_CLIENT_AMT decimal COMMENT '交易金额',
	rqo_tran_date datetime COMMENT '交易日期',
	rqo_tran_time time COMMENT '交易时间',
	-- sfm自动赋值
	rrf_rule_data varchar(3000) COMMENT '规则命中情况',
	smh_multi_org_name varchar(16) COMMENT '企业或部分规则',
	-- cs/cc
	-- 借记卡、信用卡
	smh_acct_type varchar(2) COMMENT '账户类型',
	smh_acctivity_type varchar(2) COMMENT 'ca',
	hct_term_owner_id varchar(23) COMMENT '设备编号',
	aqo_acct_num varchar(34) COMMENT '账号',
	aqo_branch_id varchar(15) COMMENT '开户行',
	hqo_card_num varchar(20) COMMENT '卡号',
	-- 卡限额类型/ATM/OTH/POS/TFR
	-- 
	hqo_limit_type varchar(3) COMMENT '卡限额类型',
	hqo_limit_amt decimal COMMENT '卡限额',
	hqo_limit_curr_code varchar(3) COMMENT '货币代码',
	hqo_limit_curr_conv_rate decimal COMMENT '汇率',
	hct_mer_mcc varchar(4) COMMENT '商户MCC',
	hct_term_cntry_code varchar(3) COMMENT '国家代码',
	rur_4byte_string_001 varchar(6) COMMENT 'rur_4byte_string_001',
	rur_numeric_009 decimal COMMENT 'rur_numeric_009',
	PRIMARY KEY (CMX_TRAN_ID),
	UNIQUE (CMX_TRAN_ID)
) COMMENT = '卡交易信息表';




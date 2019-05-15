SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX gen_scheme_del_flag ON gen_scheme;
DROP INDEX gen_table_del_flag ON gen_table;
DROP INDEX gen_table_name ON gen_table;
DROP INDEX gen_table_column_del_flag ON gen_table_column;
DROP INDEX gen_table_column_name ON gen_table_column;
DROP INDEX gen_table_column_sort ON gen_table_column;
DROP INDEX gen_table_column_table_id ON gen_table_column;
DROP INDEX gen_template_del_falg ON gen_template;
DROP INDEX sys_area_del_flag ON sys_area;
DROP INDEX sys_area_parent_id ON sys_area;
DROP INDEX sys_dict_del_flag ON sys_dict;
DROP INDEX sys_dict_label ON sys_dict;
DROP INDEX sys_dict_value ON sys_dict;
DROP INDEX sys_log_create_by ON sys_log;
DROP INDEX sys_log_create_date ON sys_log;
DROP INDEX sys_log_request_uri ON sys_log;
DROP INDEX sys_log_type ON sys_log;
DROP INDEX sys_mdict_del_flag ON sys_mdict;
DROP INDEX sys_mdict_parent_id ON sys_mdict;
DROP INDEX sys_menu_del_flag ON sys_menu;
DROP INDEX sys_menu_parent_id ON sys_menu;
DROP INDEX sys_office_del_flag ON sys_office;
DROP INDEX sys_office_parent_id ON sys_office;
DROP INDEX sys_office_type ON sys_office;
DROP INDEX sys_role_del_flag ON sys_role;
DROP INDEX sys_role_enname ON sys_role;
DROP INDEX sys_user_company_id ON sys_user;
DROP INDEX sys_user_del_flag ON sys_user;
DROP INDEX sys_user_login_name ON sys_user;
DROP INDEX sys_user_office_id ON sys_user;
DROP INDEX sys_user_update_date ON sys_user;



/* Drop Tables */

DROP TABLE IF EXISTS gen_scheme;
DROP TABLE IF EXISTS gen_table;
DROP TABLE IF EXISTS gen_table_column;
DROP TABLE IF EXISTS gen_template;
DROP TABLE IF EXISTS sys_area;
DROP TABLE IF EXISTS sys_dict;
DROP TABLE IF EXISTS sys_log;
DROP TABLE IF EXISTS sys_mdict;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sys_office;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_role_menu;
DROP TABLE IF EXISTS sys_role_office;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_user_role;




/* Create Tables */

CREATE TABLE gen_scheme
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 名称
	name varchar(200) BINARY COMMENT '名称',
	-- 分类
	category varchar(2000) BINARY COMMENT '分类',
	-- 生成包路径
	package_name varchar(500) BINARY COMMENT '生成包路径',
	-- 生成模块名
	module_name varchar(30) BINARY COMMENT '生成模块名',
	-- 生成子模块名
	sub_module_name varchar(30) BINARY COMMENT '生成子模块名',
	-- 生成功能名
	function_name varchar(500) BINARY COMMENT '生成功能名',
	-- 生成功能名（简写）
	function_name_simple varchar(100) BINARY COMMENT '生成功能名（简写）',
	-- 生成功能作者
	function_author varchar(100) BINARY COMMENT '生成功能作者',
	-- 生成表编号
	gen_table_id varchar(200) BINARY COMMENT '生成表编号',
	-- 创建者
	create_by varchar(64) BINARY COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE gen_table
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 名称
	name varchar(200) BINARY COMMENT '名称',
	-- 描述
	comments varchar(500) BINARY COMMENT '描述',
	-- 实体类名称
	class_name varchar(100) BINARY COMMENT '实体类名称',
	-- 关联父表
	parent_table varchar(200) BINARY COMMENT '关联父表',
	-- 关联父表外键
	parent_table_fk varchar(100) BINARY COMMENT '关联父表外键',
	-- 创建者
	create_by varchar(64) BINARY COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE gen_table_column
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 归属表编号
	gen_table_id varchar(64) BINARY COMMENT '归属表编号',
	-- 名称
	name varchar(200) BINARY COMMENT '名称',
	-- 描述
	comments varchar(500) BINARY COMMENT '描述',
	-- 列的数据类型的字节长度
	jdbc_type varchar(100) BINARY COMMENT '列的数据类型的字节长度',
	-- JAVA类型
	java_type varchar(500) BINARY COMMENT 'JAVA类型',
	-- JAVA字段名
	java_field varchar(200) BINARY COMMENT 'JAVA字段名',
	-- 是否主键
	is_pk char BINARY COMMENT '是否主键',
	-- 是否可为空
	is_null char BINARY COMMENT '是否可为空',
	-- 是否为插入字段
	is_insert char BINARY COMMENT '是否为插入字段',
	-- 是否编辑字段
	is_edit char BINARY COMMENT '是否编辑字段',
	-- 是否列表字段
	is_list char BINARY COMMENT '是否列表字段',
	-- 是否查询字段
	is_query char BINARY COMMENT '是否查询字段',
	-- 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	query_type varchar(200) BINARY COMMENT '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
	-- 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	show_type varchar(200) BINARY COMMENT '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',
	-- 字典类型
	dict_type varchar(200) BINARY COMMENT '字典类型',
	-- 其它设置（扩展字段JSON）
	settings varchar(2000) BINARY COMMENT '其它设置（扩展字段JSON）',
	-- 排序（升序）
	sort decimal COMMENT '排序（升序）',
	-- 创建者
	create_by varchar(64) BINARY COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE gen_template
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 名称
	name varchar(200) BINARY COMMENT '名称',
	-- 分类
	category varchar(2000) BINARY COMMENT '分类',
	-- 生成文件路径
	file_path varchar(500) BINARY COMMENT '生成文件路径',
	-- 生成文件名
	file_name varchar(200) BINARY COMMENT '生成文件名',
	-- 内容
	content text BINARY COMMENT '内容',
	-- 创建者
	create_by varchar(64) BINARY COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_area
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) BINARY NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) BINARY NOT NULL COMMENT '所有父级编号',
	-- 名称
	name varchar(100) BINARY NOT NULL COMMENT '名称',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 区域编码
	code varchar(100) BINARY COMMENT '区域编码',
	-- 区域类型
	type char BINARY COMMENT '区域类型',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_dict
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 数据值
	value varchar(100) BINARY NOT NULL COMMENT '数据值',
	-- 标签名
	label varchar(100) BINARY NOT NULL COMMENT '标签名',
	-- 类型
	type varchar(100) BINARY NOT NULL COMMENT '类型',
	-- 描述
	description varchar(100) BINARY NOT NULL COMMENT '描述',
	-- 排序（升序）
	sort decimal NOT NULL COMMENT '排序（升序）',
	-- 父级编号
	parent_id varchar(64) BINARY DEFAULT '0' COMMENT '父级编号',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_log
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 日志类型
	type char BINARY DEFAULT '1' COMMENT '日志类型',
	-- 日志标题
	title varchar(255) BINARY COMMENT '日志标题',
	-- 创建者
	create_by varchar(64) BINARY COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 操作IP地址
	remote_addr varchar(255) BINARY COMMENT '操作IP地址',
	-- 用户代理
	user_agent varchar(255) BINARY COMMENT '用户代理',
	-- 请求URI
	request_uri varchar(255) BINARY COMMENT '请求URI',
	-- 操作方式
	method varchar(5) BINARY COMMENT '操作方式',
	-- 操作提交的数据
	params text BINARY COMMENT '操作提交的数据',
	-- 异常信息
	exception text BINARY COMMENT '异常信息',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_mdict
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) BINARY NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) BINARY NOT NULL COMMENT '所有父级编号',
	-- 名称
	name varchar(100) BINARY NOT NULL COMMENT '名称',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 描述
	description varchar(100) BINARY COMMENT '描述',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_menu
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) BINARY NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) BINARY NOT NULL COMMENT '所有父级编号',
	-- 名称
	name varchar(100) BINARY NOT NULL COMMENT '名称',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 链接
	href varchar(2000) BINARY COMMENT '链接',
	-- 目标
	target varchar(20) BINARY COMMENT '目标',
	-- 图标
	icon varchar(100) BINARY COMMENT '图标',
	-- 是否在菜单中显示
	is_show char BINARY NOT NULL COMMENT '是否在菜单中显示',
	-- 权限标识
	permission varchar(200) BINARY COMMENT '权限标识',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_office
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 父级编号
	parent_id varchar(64) BINARY NOT NULL COMMENT '父级编号',
	-- 所有父级编号
	parent_ids varchar(2000) BINARY NOT NULL COMMENT '所有父级编号',
	-- 名称
	name varchar(100) BINARY NOT NULL COMMENT '名称',
	-- 排序
	sort decimal NOT NULL COMMENT '排序',
	-- 归属区域
	area_id varchar(64) BINARY NOT NULL COMMENT '归属区域',
	-- 区域编码
	code varchar(100) BINARY COMMENT '区域编码',
	-- 机构类型
	type char BINARY NOT NULL COMMENT '机构类型',
	-- 机构等级
	grade char BINARY NOT NULL COMMENT '机构等级',
	-- 联系地址
	address varchar(255) BINARY COMMENT '联系地址',
	-- 邮政编码
	zip_code varchar(100) BINARY COMMENT '邮政编码',
	-- 负责人
	master varchar(100) BINARY COMMENT '负责人',
	-- 电话
	phone varchar(200) BINARY COMMENT '电话',
	-- 传真
	fax varchar(200) BINARY COMMENT '传真',
	-- 邮箱
	email varchar(200) BINARY COMMENT '邮箱',
	-- 是否启用
	USEABLE varchar(64) BINARY COMMENT '是否启用',
	-- 主负责人
	PRIMARY_PERSON varchar(64) BINARY COMMENT '主负责人',
	-- 副负责人
	DEPUTY_PERSON varchar(64) BINARY COMMENT '副负责人',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_role
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 归属机构
	office_id varchar(64) BINARY COMMENT '归属机构',
	-- 角色名称
	name varchar(100) BINARY NOT NULL COMMENT '角色名称',
	-- 英文名称
	enname varchar(255) BINARY COMMENT '英文名称',
	-- 角色类型
	role_type varchar(255) BINARY COMMENT '角色类型',
	-- 数据范围
	data_scope char BINARY COMMENT '数据范围',
	-- 是否系统数据
	is_sys varchar(64) BINARY COMMENT '是否系统数据',
	-- 是否可用
	useable varchar(64) BINARY COMMENT '是否可用',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_role_menu
(
	-- 角色编号
	role_id varchar(64) BINARY NOT NULL COMMENT '角色编号',
	-- 菜单编号
	menu_id varchar(64) BINARY NOT NULL COMMENT '菜单编号',
	PRIMARY KEY (role_id, menu_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_role_office
(
	-- 角色编号
	role_id varchar(64) BINARY NOT NULL COMMENT '角色编号',
	-- 机构编号
	office_id varchar(64) BINARY NOT NULL COMMENT '机构编号',
	PRIMARY KEY (role_id, office_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_user
(
	-- 编号
	id varchar(64) BINARY NOT NULL COMMENT '编号',
	-- 归属公司
	company_id varchar(64) BINARY NOT NULL COMMENT '归属公司',
	-- 归属部门
	office_id varchar(64) BINARY NOT NULL COMMENT '归属部门',
	-- 登录名
	login_name varchar(100) BINARY NOT NULL COMMENT '登录名',
	-- 密码
	password varchar(100) BINARY NOT NULL COMMENT '密码',
	-- 工号
	no varchar(100) BINARY COMMENT '工号',
	-- 姓名
	name varchar(100) BINARY NOT NULL COMMENT '姓名',
	-- 邮箱
	email varchar(200) BINARY COMMENT '邮箱',
	-- 电话
	phone varchar(200) BINARY COMMENT '电话',
	-- 手机
	mobile varchar(200) BINARY COMMENT '手机',
	-- 用户类型
	user_type char BINARY COMMENT '用户类型',
	-- 用户头像
	photo varchar(1000) BINARY COMMENT '用户头像',
	-- 最后登陆IP
	login_ip varchar(100) BINARY COMMENT '最后登陆IP',
	-- 最后登陆时间
	login_date datetime COMMENT '最后登陆时间',
	-- 是否可登录
	login_flag varchar(64) BINARY COMMENT '是否可登录',
	-- 创建者
	create_by varchar(64) BINARY NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) BINARY NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) BINARY COMMENT '备注信息',
	-- 删除标记
	del_flag char BINARY DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


CREATE TABLE sys_user_role
(
	-- 用户编号
	user_id varchar(64) BINARY NOT NULL COMMENT '用户编号',
	-- 角色编号
	role_id varchar(64) BINARY NOT NULL COMMENT '角色编号',
	PRIMARY KEY (user_id, role_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;



/* Create Indexes */

CREATE INDEX gen_scheme_del_flag USING BTREE ON gen_scheme (del_flag ASC);
CREATE INDEX gen_table_del_flag USING BTREE ON gen_table (del_flag ASC);
CREATE INDEX gen_table_name USING BTREE ON gen_table (name ASC);
CREATE INDEX gen_table_column_del_flag USING BTREE ON gen_table_column (del_flag ASC);
CREATE INDEX gen_table_column_name USING BTREE ON gen_table_column (name ASC);
CREATE INDEX gen_table_column_sort USING BTREE ON gen_table_column (sort ASC);
CREATE INDEX gen_table_column_table_id USING BTREE ON gen_table_column (gen_table_id ASC);
CREATE INDEX gen_template_del_falg USING BTREE ON gen_template (del_flag ASC);
CREATE INDEX sys_area_del_flag USING BTREE ON sys_area (del_flag ASC);
CREATE INDEX sys_area_parent_id USING BTREE ON sys_area (parent_id ASC);
CREATE INDEX sys_dict_del_flag USING BTREE ON sys_dict (del_flag ASC);
CREATE INDEX sys_dict_label USING BTREE ON sys_dict (label ASC);
CREATE INDEX sys_dict_value USING BTREE ON sys_dict (value ASC);
CREATE INDEX sys_log_create_by USING BTREE ON sys_log (create_by ASC);
CREATE INDEX sys_log_create_date USING BTREE ON sys_log (create_date ASC);
CREATE INDEX sys_log_request_uri USING BTREE ON sys_log (request_uri ASC);
CREATE INDEX sys_log_type USING BTREE ON sys_log (type ASC);
CREATE INDEX sys_mdict_del_flag USING BTREE ON sys_mdict (del_flag ASC);
CREATE INDEX sys_mdict_parent_id USING BTREE ON sys_mdict (parent_id ASC);
CREATE INDEX sys_menu_del_flag USING BTREE ON sys_menu (del_flag ASC);
CREATE INDEX sys_menu_parent_id USING BTREE ON sys_menu (parent_id ASC);
CREATE INDEX sys_office_del_flag USING BTREE ON sys_office (del_flag ASC);
CREATE INDEX sys_office_parent_id USING BTREE ON sys_office (parent_id ASC);
CREATE INDEX sys_office_type USING BTREE ON sys_office (type ASC);
CREATE INDEX sys_role_del_flag USING BTREE ON sys_role (del_flag ASC);
CREATE INDEX sys_role_enname USING BTREE ON sys_role (enname ASC);
CREATE INDEX sys_user_company_id USING BTREE ON sys_user (company_id ASC);
CREATE INDEX sys_user_del_flag USING BTREE ON sys_user (del_flag ASC);
CREATE INDEX sys_user_login_name USING BTREE ON sys_user (login_name ASC);
CREATE INDEX sys_user_office_id USING BTREE ON sys_user (office_id ASC);
CREATE INDEX sys_user_update_date USING BTREE ON sys_user (update_date ASC);




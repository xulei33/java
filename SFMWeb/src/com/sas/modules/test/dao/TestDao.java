/**
 * 
 */
package com.sas.modules.test.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.test.entity.Test;

/**
 * 测试DAO接口
 * 
 * @version 2013-10-17
 */
@MyBatisDao
public interface TestDao extends CrudDao<Test> {
	
}

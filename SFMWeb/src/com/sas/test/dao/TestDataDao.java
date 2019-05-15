/**
 * 
 */
package com.sas.test.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.test.entity.TestData;

/**
 * 单表生成DAO接口
 * 
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestDataDao extends CrudDao<TestData> {
	
}
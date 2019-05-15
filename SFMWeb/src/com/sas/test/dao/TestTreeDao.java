/**
 * 
 */
package com.sas.test.dao;

import com.common.persistence.TreeDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * 
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}
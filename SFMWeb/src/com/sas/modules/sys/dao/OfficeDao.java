/**
 * 
 */
package com.sas.modules.sys.dao;

import com.common.persistence.TreeDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}

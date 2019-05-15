/**
 * 
 */
package com.sas.modules.gen.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.gen.entity.GenTable;

/**
 * 业务表DAO接口
 * 
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {
	
}

/**
 * 
 */
package com.sas.modules.gen.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 * 
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableColumnDao extends CrudDao<GenTableColumn> {
	
	public void deleteByGenTableId(String genTableId);
}

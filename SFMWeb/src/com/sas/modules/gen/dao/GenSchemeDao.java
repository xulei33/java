/**
 * 
 */
package com.sas.modules.gen.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.gen.entity.GenScheme;

/**
 * 生成方案DAO接口
 * 
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenSchemeDao extends CrudDao<GenScheme> {
	
}

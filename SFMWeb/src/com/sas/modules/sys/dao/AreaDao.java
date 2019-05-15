/**
 * 
 */
package com.sas.modules.sys.dao;

import com.common.persistence.TreeDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}

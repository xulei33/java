/**
 * 
 */
package com.sas.modules.act.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.act.entity.Act;

/**
 * 审批DAO接口
 * @author thinkgem
 * @version 2014-05-16
 */
@MyBatisDao
public interface ActDao extends CrudDao<Act> {

	public int updateProcInsIdByBusinessId(Act act);
	
}

/**
 * 
 */
package com.sas.modules.sys.dao;

import java.util.List;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.sys.entity.Menu;

/**
 * 菜单DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
}

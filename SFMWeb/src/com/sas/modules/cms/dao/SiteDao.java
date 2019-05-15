/**
 * 
 */
package com.sas.modules.cms.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.cms.entity.Site;

/**
 * 站点DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface SiteDao extends CrudDao<Site> {

}

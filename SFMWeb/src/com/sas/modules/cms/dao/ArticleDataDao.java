/**
 * 
 */
package com.sas.modules.cms.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.cms.entity.ArticleData;

/**
 * 文章DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
}

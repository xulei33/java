/**
 * 
 */
package com.sas.modules.cms.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.cms.entity.Guestbook;

/**
 * 留言DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface GuestbookDao extends CrudDao<Guestbook> {

}

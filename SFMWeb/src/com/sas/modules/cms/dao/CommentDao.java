/**
 * 
 */
package com.sas.modules.cms.dao;

import com.common.persistence.CrudDao;
import com.common.persistence.annotation.MyBatisDao;
import com.sas.modules.cms.entity.Comment;

/**
 * 评论DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface CommentDao extends CrudDao<Comment> {

}

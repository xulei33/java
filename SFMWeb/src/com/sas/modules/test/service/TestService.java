/**
 * 
 */
package com.sas.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.CrudService;
import com.sas.modules.test.dao.TestDao;
import com.sas.modules.test.entity.Test;

/**
 * 测试Service
 * 
 * @version 2013-10-17
 */
@Service
@Transactional(readOnly = true)
public class TestService extends CrudService<TestDao, Test> {

}

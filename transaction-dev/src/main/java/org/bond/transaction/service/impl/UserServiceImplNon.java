package org.bond.transaction.service.impl;

import java.util.Date;

import org.bond.transaction.mapper.UserMapper;
import org.bond.transaction.model.Order;
import org.bond.transaction.model.User;
import org.bond.transaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserServiceImplNon  {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserMapper userMapper;

	public void saveOrder2() {
//		logger.info(AopContext.currentProxy().getClass().getName());
		logger.info("####### isApoProxy = " +  AopUtils.isAopProxy(this));
		logger.info("####### isCglibProxy = " + AopUtils.isCglibProxy(this));
		logger.info("####### isJdkDynamicProxy = " + AopUtils.isJdkDynamicProxy(this));
		Order order = new Order();
		order.setForderId("222");
		order.setFcreateTime(new Date());
		userMapper.saveOrder(order);
	}

}
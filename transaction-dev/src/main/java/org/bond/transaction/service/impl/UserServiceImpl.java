package org.bond.transaction.service.impl;

import java.util.Date;

import org.bond.transaction.mapper.UserMapper;
import org.bond.transaction.model.Order;
import org.bond.transaction.model.User;
import org.bond.transaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserMapper userMapper;

	/**
	 * @Transactional(propagation=Propagation.NOT_SUPPORTED) NOT_SUPPORTED:容器不为这个方法开启事务,以非事务方式执行操作，如果当前存在事务，就把当前事务挂起，前提是defaultAutoCommit设置为false
	 *                                                       如果数据源的defaultAutoCommit设置为True
	 *                                                       那么方法中如果定义捕获了异常，事务是不会回滚的
	 *                                                       如果没有定义捕获异常则事务会回滚
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED) // 指定回滚，遇到异常Exception时回滚
	public int saveUserByNotSupported(User user) {
		user.setFcreateTime(new Date());
		user.setFmodifyTime(new Date());
		int returnInt = userMapper.saveUser(user);
		logger.info("saveUser called " + user.getFuid() + " ####" + returnInt);
		return returnInt;
	}

	/**
	 * 只读事务
	 */
	@Override
	@Transactional(readOnly = true)
	public int saveUserByReadOnly(User user) {
		user.setFcreateTime(new Date());
		user.setFmodifyTime(new Date());
		int returnInt = userMapper.saveUser(user);
		logger.info("saveUser called " + user.getFuid() + " ####" + returnInt);
		return user.getFuid();
	}

	/**
	 * 默认配置下,Spring只有在抛出的异常为运行时unchecked异常时才回滚该事务,
	 * 也就是抛出的异常为RuntimeException的子类(Errors也会导致事务回滚)。 而抛出checked异常则不会导致事务回滚。
	 * 结果就是:方法中如果捕获了异常,事务是不会回滚的, 如果没有定义捕获异常则事务会回滚,但可以通过rollbackFor使其事务回滚
	 * 
	 */
	@Override
	@Transactional
	public int saveUserByException(User user) {
		user.setFcreateTime(new Date());
		user.setFmodifyTime(new Date());
		int returnInt = userMapper.saveUser(user);
		try {
			int i = 2 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveUser called " + user.getFuid() + " ####" + returnInt);
		return user.getFuid();
	}

	/**
	 * 
	 */
	@Override
	 @Transactional(propagation=Propagation.REQUIRED)
	// @Transactional(rollbackFor=Exception.class)
    @Retryable(value = ArithmeticException.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
	public int saveUser(User user) {
		logger.info("##################### saveUser #####################");
		user.setFcreateTime(new Date());
		user.setFmodifyTime(new Date());
		userMapper.saveUser(user);
		int i = 1/0;
		return user.getFuid();
	}
	
	@Recover
	public void recover(ArithmeticException e){
		logger.info("##################### recover #####################");
	}

//	@Transactional(propagation=Propagation.REQUIRED)
	public void saveOrder2() {
		Order order = new Order();
		order.setForderId("1");
		order.setFcreateTime(new Date());
		userMapper.saveOrder(order);
		int i = 1/0;
	}

	@Override
	// @Transactional(propagation=Propagation.REQUIRES_NEW)
	public int saveOrder(Order order) {
		order.setForderId("111111111111111111111222222222222222222222233333333333333333333");
		order.setFcreateTime(new Date());
		return userMapper.saveOrder(order);
	}

	@Override
	@Transactional(noRollbackFor = ArithmeticException.class)
	public void saveUserNoReturn(User user) {
		user.setFcreateTime(new Date());
		user.setFmodifyTime(new Date());
		userMapper.saveUserNoReturn(user);
		Order order = new Order();
		order.setForderId("1");
		userMapper.saveOrder(order);
		logger.info("saveUserNoReturn" + user.getFuid() + "");
		throw new RuntimeException("Error");
	}

}

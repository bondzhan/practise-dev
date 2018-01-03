package org.bond.transaction.service;

import org.bond.transaction.model.Order;
import org.bond.transaction.model.User;

public interface UserService {
	
	int saveUser(User user);

	void saveUserNoReturn(User user);

	int saveOrder(Order order);
	
	int saveUserByNotSupported(User user);
	
	int saveUserByException(User user);
	
	int saveUserByReadOnly(User user);
	
	void recover(ArithmeticException e);
}

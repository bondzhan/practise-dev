package org.bond.transaction.mapper;

import org.bond.transaction.model.Order;
import org.bond.transaction.model.User;

public interface UserMapper {
	User findUserByName(String funame);

	int saveUser(User user);
	
	void saveUserNoReturn(User user);
	
	int saveOrder(Order order);
	
}
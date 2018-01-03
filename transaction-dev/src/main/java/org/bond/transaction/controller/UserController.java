/**   
* @Title: UserController.java 
* @Package org.bond.transaction.controller 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author bond
* @date 2017��11��30�� ����2:29:36 
* @company ��Ȩ���� �����������ƹ�Ӧ�����޹�˾
* @version V1.0   
*/
package org.bond.transaction.controller;

import org.bond.transaction.model.User;
import org.bond.transaction.service.UserService;
import org.bond.transaction.service.impl.UserServiceImplNon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserServiceImplNon userService2;
	
	@RequestMapping("/addUser")
	public ResponseEntity addUser(User user){
		logger.info("addUser");
		if(Strings.isNullOrEmpty(user.getFuname())){
			logger.info("funame is null or empty");
			return ResponseEntity.noContent().build();
		}
		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping("/addOrder")
	public ResponseEntity addOrder(){
		logger.info("addOrder");
		userService2.saveOrder2();
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/addUserNoReturn")
	public ResponseEntity addUserNoReturn(User user){
		logger.info("addUserNoReturn");
		if(Strings.isNullOrEmpty(user.getFuname())){
			logger.info("funame is null or empty");
			return ResponseEntity.noContent().build();
		}
		userService.saveUserNoReturn(user);
		return ResponseEntity.ok(user);
	}
}

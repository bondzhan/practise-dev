package org.bond.proxy.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubjectImpl implements Subject {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void sayHi(String str) {
		logger.info("##############" + str + "##############");
//		throw new ArithmeticException();
	}

}

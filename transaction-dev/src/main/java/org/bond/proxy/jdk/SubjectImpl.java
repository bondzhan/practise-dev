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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		logger.info(super.hashCode() + "");
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		logger.info(super.toString());
		return super.toString();
	}

	
	
}

package com.bl.annotation.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JunitDemo {

	public static void main(String[] args) {

		JunitTest jUnit = new JunitTest();

		for (Method method : jUnit.getClass().getMethods()) {
			
			if(method.isAnnotationPresent(Test.class)) {
				try {
					method.invoke(jUnit);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
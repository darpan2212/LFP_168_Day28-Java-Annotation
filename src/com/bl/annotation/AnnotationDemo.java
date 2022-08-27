package com.bl.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {

	@MethodInfo(date = "27/08/2022", comment = "This is new method to print object")
	@Override
	public String toString() {
		return "Annotation Demo example";
	}

	@Deprecated
	@MethodInfo(date = "27/08/2022", comment = "This is old method to print object")
	public String printObj() {
		return super.toString();
	}

	public String methodInfo() {
		return "author : Darpan, date : 27/08/2022";
	}

	public static void main(String[] args) {
		for (Method method : AnnotationDemo.class.getMethods()) {
			System.out.println(method);
			for (Annotation annotation : method.getAnnotations()) {
				System.out.println(annotation);
			}
			if (method.isAnnotationPresent(MethodInfo.class)) {
				MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
				System.out.println(methodInfo.comment());
			}
			System.out.println("________________________________");
		}
	}

}
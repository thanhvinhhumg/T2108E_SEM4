package com.example.springbean;

import com.example.springbean.bean.Department;
import com.example.springbean.bean.User;
import com.example.springbean.config.BeanConfig;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBeanApplication {

	public static void main(String[] args) {
		// using bean factory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("bean.xml");
		User user = (User)factory.getBean("user");
		System.err.println("bean factory user: "+user.toString());

		// using application context
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user1 = (User)context.getBean("user");
		System.err.println("application context user: "+user1.toString());

		//autowrited
		Department department = (Department) context.getBean("department");
		System.err.println("department: "+department.toString());

		// using annotation
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BeanConfig.class);
		ctx.refresh();
		User userBean = ctx.getBean(User.class);
		System.err.println("annotation bean : "+userBean.toString());
	}

}

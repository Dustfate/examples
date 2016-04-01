package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext();
		context.getBean("");
		ApplicationContext context2 = new ClassPathXmlApplicationContext();
		
	}
}

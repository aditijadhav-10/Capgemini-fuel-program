package Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import BankBeans.Bank;

public class Main1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		Bank sbi = context.getBean(Bank.class);
		sbi.diaplay();

	}

}

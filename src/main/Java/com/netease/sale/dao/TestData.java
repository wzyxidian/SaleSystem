package com.netease.sale.dao;

import com.netease.sale.meta.Product;
import com.netease.sale.meta.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestData {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		ProductDao dao = context.getBean("productDao", ProductDao.class);
		List<Product> userList = dao.getProductList();
		for (Product user: userList) {
			System.out.println(user.getAbstracts());
		}
		
		Product liLei = dao.getProduct(1);
		System.out.println("getByFirstName: " + liLei.getAbstracts() + " " + liLei.getDetail());

		((ConfigurableApplicationContext) context).close();
	}
}

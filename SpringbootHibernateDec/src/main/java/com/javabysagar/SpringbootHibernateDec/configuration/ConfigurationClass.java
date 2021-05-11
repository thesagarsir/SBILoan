package com.javabysagar.SpringbootHibernateDec.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.javabysagar.SpringbootHibernateDec.entities.Country;
import com.javabysagar.SpringbootHibernateDec.entities.Employee;

@Configuration
public class ConfigurationClass {

	@Autowired
	DataSource datasource;
	
	@Bean
	public LocalSessionFactoryBean getFactoryBean()
	{
		
		System.out.println("getFactoryBean()");
		LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
		factorybean.setAnnotatedClasses(Employee.class,Country.class);
		factorybean.setDataSource(datasource);//
		return factorybean;
		
	}
	
	
	
}

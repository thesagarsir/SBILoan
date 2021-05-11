package com.javabysagar.SpringbootHibernateDec.dao;

import java.sql.Date;


import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabysagar.SpringbootHibernateDec.entities.Country;
import com.javabysagar.SpringbootHibernateDec.entities.Employee;

@Repository
public class SpringDao {
//database related -queries
	@Autowired
	SessionFactory sessionfactory;
	
	public List<Employee> ListEmployee() {
		
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> listemployee=criteria.list();
	
		/*for(Employee emp:listemployee)
		{
			System.out.println(emp.getName());
		}*/
		return listemployee;
	}

	public Employee getEmployeebyId(int id) {
	
		Session session=sessionfactory.openSession();
		//select * from Employee;
		Criteria criteria=session.createCriteria(Employee.class);
		//where id=?
		
		criteria.add(Restrictions.eq("id",id));
		
		Employee emp=(Employee) criteria.uniqueResult();
		
		
		
		return emp;
	}

	public Employee getEmployeebyName(String name) {

		Session session=sessionfactory.openSession();
		//select * from Employee;
		Criteria criteria=session.createCriteria(Employee.class);
		//where name=?
		criteria.add(Restrictions.eq("name",name));
	
		
		Employee emp=(Employee) criteria.uniqueResult();
		
		/*Query query=session.createQuery("select id from Employee");
		query.setParameter("name",name);
		query.list();*/
		
		
		return emp;
	}

	public List<Employee> getEmployeebyStatus(String status) {
		
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("status",status));
		List<Employee> listemp=criteria.list();
		
		for(Employee emp:listemp)
		{
			System.out.println(emp.getName());
		}
		
		return listemp;
	}

	public boolean saveEmployee(Employee emp) {
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Long millies=System.currentTimeMillis();
		Date date=new Date(millies);
		
		System.out.println(date);
		emp.setCreateddtm(date);
		emp.setUpdateddtm(date);
		session.save(emp);
		tx.commit();
		return true;
	}

	public boolean saveCountry(Country country) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(country);
		tx.commit();
		return true;
	}

	public boolean deletecountrybyname(String cname) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("DELETE FROM Country where cname=:cname");

		query.setParameter("cname", cname);
		int i=query.executeUpdate();
		tx.commit();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean deleteEmployeebyId(int id) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("DELETE FROM Employee where id=:id");
		query.setParameter("id", id);
		int i=query.executeUpdate();
		tx.commit();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean updateCountry(Country country) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("update Country SET cname=:cname where cid=:cid");
		query.setParameter("cname",country.getCname());
		query.setParameter("cid",country.getCid());
		int i=query.executeUpdate();
		tx.commit();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean updateEmployee(Employee emp) {
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("update Employee SET country=:country where id=:id");
		query.setParameter("name", emp.getName());
		query.setParameter("phone", emp.getPhoneno());
		query.setParameter("dept", emp.getDepartmentit());
		query.setParameter("status", emp.getStatus());
		query.setParameter("date1",emp.getCreateddtm());
		query.setParameter("createdby", emp.getCreatedby());
		
		Long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		
		query.setParameter("date2", date);
		query.setParameter("updatedby", emp.getUpdatedby());
		query.setParameter("country", emp.getCountry());
		query.setParameter("id", emp.getId());
		
		int i=query.executeUpdate();
		tx.commit();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public List<Employee> employeeListBeforeToday() {
	
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Employee where createddtm <:date");
		/*long millis=System.currentTimeMillis();
		Date date=new Date(millis);*/
		
		java.util.Date date=new java.util.Date();
		System.out.println(date);
		query.setParameter("date", date);
		
		List<Employee> listemp=query.list();
		return listemp;
	}

	
	
}

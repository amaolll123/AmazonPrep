package com.amao.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.amao.todo.pojo.Todo;
@Service
public class TodoPersistenceService {
	private static SessionFactory factory;
	
	public void getSessionFactory(){
		try{
			Configuration cf  = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cf.getProperties());
			SessionFactory sf = cf.buildSessionFactory(builder.build());
			factory = sf;
		}catch (Exception e) {
			System.out.println("Failed to build a sessionFactory");
			e.printStackTrace();
		}
		
	}
	
	public List<Todo> retrieveTodos(String user) {
		getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Todo> filteredTodos = new ArrayList<Todo>();
		
		try {
			tx = session.beginTransaction();
			List todos = session.createQuery("from Todo").list();
			
			for(Object t : todos){
				Todo todo = (Todo) t;
				if(todo.getUser().equals(user)){
					filteredTodos.add(todo);
				}
				
			}
			
			tx.commit();
			return filteredTodos;
		} catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
		return filteredTodos;
	}
	
	public Integer addProduct(Todo t){
		getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer todoId = null;
		try {
			tx = session.beginTransaction();
			
			
			todoId = (Integer) session.save(t);
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return todoId;
	}
	
	/*
	 * public Integer addProduct(Product p){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer productID = null;
		try {
			tx = session.beginTransaction();
			productID = (Integer) session.save(p);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return productID;
	}
	 * 
	 * 
	 * 
	 * public void listProducts(){
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("from Product").list();
			
			for(Object p : products){
				Product prod = (Product) p;
				System.out.println(prod.getId()+" "+prod.getName()+" "+prod.getPrice());
				
			}
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(),
				false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	public Todo retrieveTodo(int id){
		for(Todo todo: todos){
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}
	

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
				todoCount--;
			}
		}
	}*/
}

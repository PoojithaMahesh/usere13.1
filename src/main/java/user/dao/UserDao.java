package user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import user.dto.User;

public class UserDao {
// save user method
//	to save the user  what are all the things neccessary
//	an entire user object 
	
	public void saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	public void findUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
//			id is present
			System.out.println(dbUser);
			System.out.println("Data fetched successfully");
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	
	public void deleteUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbUser);
			entityTransaction.commit();
			System.out.println("Data deleted successfully");
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	
	public void updateUser(int id,User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class, id);
		if(dbUser!=null) {
//			id is present then i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			user.setId(id);
			entityManager.merge(user);
			entityTransaction.commit();	
			System.out.println("Data updated successfully");
		}else {
//			id is not present
			System.out.println("Sorry Id is not present");
		}
		
		
		
	}
	
	
	
	
	
}

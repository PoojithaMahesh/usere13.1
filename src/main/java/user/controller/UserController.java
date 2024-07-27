package user.controller;

import java.util.Scanner;

import user.dao.UserDao;
import user.dto.User;

public class UserController {
public static void main(String[] args) {
//	hii
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("WELCOME TO USER APPLICATION");
	System.out.println("ENTER 1 TO SAVE THE DATA");
	System.out.println("ENTER 2 TO UPDATE THE DATA");
	System.out.println("ENTER 3 TO FIND THE DATA");
	System.out.println("ENTER 4 TO DELETE THE DATA");
	int choice=scanner.nextInt();
	UserDao dao=new UserDao();
	
	switch (choice) {
	case 1:{
//		choice =1 then you need to save the data
		System.out.println("Give id");
		int id=scanner.nextInt();
		System.out.println("give name");
		String name=scanner.next();
		System.out.println("give address");
		String address=scanner.next();
		System.out.println("give phonenumber");
		long phone=scanner.nextLong();
		User user=new User();
		user.setAddress(address);
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		dao.saveUser(user);
		System.out.println("User data saved successfully");
	}
     break;
	case 2:{
//		choice=2 then they want to update the data
//		id and entire user object
		
		System.out.println("Give id to be updated");
		int id=scanner.nextInt();
		System.out.println("give name");
		String name=scanner.next();
		System.out.println("give address");
		String address=scanner.next();
		System.out.println("give phonenumber");
		long phone=scanner.nextLong();
		User user=new User();
		user.setAddress(address);
		user.setName(name);
		user.setPhone(phone);
		dao.updateUser(id, user);
	}break;
	case 3 :{
		System.out.println("Give id to be fetched");
		int id=scanner.nextInt();
		dao.findUser(id);
	}break;
	case 4 :{
		System.out.println("Give id to be deleted");
		int id=scanner.nextInt();
		dao.deleteUser(id);
	}
	
	}
}
}

package jdbc_user.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc_user.dao.UserCrud;
import jdbc_user.dto.User;

public class UserController {
public static Scanner scr = new Scanner(System.in);
public static UserCrud uc = new UserCrud();
public static int count=0;
	public static void main(String[] args) throws SQLException {
		uc.create();
		System.out.println(".........welcome......");
		boolean values=true;
		do {
			System.out.println("Enter your choice \n 1.Registration \n 2.Login \n 3.Exit ");
			int value = scr.nextInt();
			if(value==1) {
				save();
			}else if(value==2) {
				login();
			}else if(value==3) {
				values=false;
			}else {
				System.out.println("wrong choice you make place choice again.......");
			}
			
		}while(values);
		System.out.println(".....Thank you....");
	}
	public static void save() {
		System.out.println("Enter the email :");
		String email = scr.next();
		System.out.println("Enter the name :");
		scr.nextLine();
		String name = scr.nextLine();
		System.out.println("Enter the password :");
		String password = scr.next();
		System.out.println("Enter the phone number :");
		long phno= scr.nextLong();
		System.out.println("Enter the age :");
		int age = scr.nextInt();
		System.out.println("Enter the gender :");
		String gender = scr.next();
		System.out.println("Enter the living place :");
		String place = scr.next();
		System.out.println("Enter the date of birthday (YYYY-MM-DD):");
		String dob = scr.next();
		Date d =Date.valueOf(dob);
		User u = new User(email,name,password,phno,age,gender,place,d);
		try {
			uc.saveUser(u);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("something error occured");
			save();
		}
		if(uc.count>0) {
			System.out.println("Registration is completed.....");
		}
	}
	public static void login1() throws SQLException{
		System.out.println("Enter the Email:");
		String email=scr.next();
		System.out.println("Enter the password:");
		String password=scr.next();
		User u = new User();
		u.em=email;
		u.ps=password;
		uc.fatchUser(u);
	}
	public static void login() throws SQLException {
		boolean values =true;
		System.out.println("Enter the Email:");
		String email=scr.next();
		System.out.println("Enter the password:");
		String password=scr.next();
		User u = new User();
		u.em=email;
		u.ps=password;
		uc.fatchUser(u);
			do {
				System.out.println("Enter your choice \n 1.fetch \n 2.update \n 3.Delete \n 4.Exit  ");
				int value=scr.nextInt();
				if(value==1) {
					System.out.println(u);
					
				}else if(value==2) {
					update(u);
				}else if(value==3) {
					uc.deleteUser(u);
					if(count>0) {
						System.out.println("delete the account successfull.....");
						System.out.println("due to the deletion of account you have to create new account");
					}
					values=false;
				}else if(value==4) {
					values=false;
				}
				
			}while(values);
	}
	
	public static void update(User u) throws SQLException {
		System.out.println("Enter which date to be update: \n 1.email \n 2.name \n 3.password \n 4.phone number \n 5.age "
				+"\n 6.gender \n 7.living place \n 8.date of Birth ");
		int v=scr.nextInt();
		boolean val=true;
		while(val) {
			if(v==1||v==2||v==3||v==6||v==7) {
				val=false;
				System.out.println("Enter the update date:");
				scr.nextLine();
				String s=scr.nextLine();
				uc.updateUser(u, v, s);
			}else if(v==5) {
				val=false;
				System.out.println("Enter the update date:");
				int s=scr.nextInt();
				uc.updateUser(u, v, s);
			}else if(v==8) {
				val=false;
				System.out.println("Enter the update date (YYYY-MM-DD):");
				scr.nextLine();
				String s=scr.nextLine();
				uc.updateUser(u, v, s);
				
			}else if(v==4) {
				val=false;
				System.out.println("Enter the update date:");
				long s = scr.nextLong();
				uc.updateUser(u, v, s);
			}else {
				System.out.println("wrong choice you make place choice again.......");
				v=scr.nextInt();
			}
		}
		if(u.count>0) {
			System.out.println("updated successfull.....");
			if(v==1||v==3) {
				System.out.println("due to the change of the password or email");
				change(u);
			}
		}
	}
	public static void change(User u) throws SQLException {
		System.out.println("Enter the Email:");
		String email=scr.next();
		System.out.println("Enter the password:");
		String password=scr.next();
		u.em=email;
		u.ps=password;
		uc.fatchUser(u);
	}


}

package jdbc_user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

import jdbc_user.controller.UserController;
import jdbc_user.dto.User;

public class UserCrud {

	public int  count;
	public void create() throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?createDatabaseIfNotExist=true","root","root");
		Statement s=con.createStatement();
		s.execute("create table If Not Exists user(Email varchar(45) primary key,User_Name varchar(45) not null,password varchar(45) not null,Phone_Number BIGINT not null unique,age int not null,gender varchar(45) not null,living_place varchar(45) not null,dob date not null)");
		s.close();
		con.close();
	}
	public void saveUser(User s) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
		PreparedStatement ps =con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
		ps.setString(1, s.getEmail());
		ps.setString(2,s.getName());
		ps.setString(6,s.getGender());
		ps.setString(3,s.getPassword());
		ps.setLong(4, s.getPhone());
		ps.setInt(5,s.getAge());
		ps.setString(7,s.getPlace());
		ps.setDate(8,s.getDob());
		count=ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	public  void fatchUser(User u) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
		PreparedStatement ps =con.prepareStatement("select * from user");
		ResultSet rs =ps.executeQuery();
		String email=u.em;
		String password=u.ps;
		while(rs.next()) {
			u.e.add(rs.getString(1));
			u.p.add(rs.getString(3));
		}
		if(u.e.contains(email)) {
			if(u.p.contains(password)) {
				UserCrud uc =new UserCrud();
				uc.fatchUser1(u);
			}else {
				System.out.println("Enter the current password");
				UserController.login1();
			}
		}else {
			System.out.println("Enter the current email");
			UserController.login1();
		}
			
	}
	public  void fatchUser1(User u) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
		PreparedStatement ps =con.prepareStatement("select * from user where email='"+u.em+"' and password='"+u.ps+"'");
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
					u.setEmail(rs.getString(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setPhone(rs.getLong(4));
					u.setAge(rs.getInt(5));
					u.setGender(rs.getString(6));
					u.setPlace(rs.getString(7));
					u.setDob(rs.getDate(8));
		}
	}
	public void updateUser(User u,int i,Object obj) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
		//1.email2.name3.password4.phone number5.age  6.gender \n 7.living place \n 8.date of Birth 
		if(i==1) {
			PreparedStatement ps =con.prepareStatement("update user set email='"+(String)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==2) {
			PreparedStatement ps =con.prepareStatement("update user set User_name='"+(String)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==3) {
			PreparedStatement ps =con.prepareStatement("update user set password='"+(String)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==4) {
			PreparedStatement ps =con.prepareStatement("update user set phone_number='"+(long)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==5) {
			PreparedStatement ps =con.prepareStatement("update user set age='"+(int)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==6) {
			PreparedStatement ps =con.prepareStatement("update user set gender='"+(String)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==7) {
			PreparedStatement ps =con.prepareStatement("update user set living_place='"+(String)obj+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		if(i==8) {
			Date obj1=Date.valueOf((String)obj);
			System.out.println(obj1);
			PreparedStatement ps =con.prepareStatement("update user set dob='"+obj1+"' where email='"+u.em+"' and password='"+u.ps+"'");
			u.count=ps.executeUpdate();
			ps.close();
			con.close();
		}
		fatchUser1(u);
	}
	public void deleteUser(User u) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
		PreparedStatement ps =con.prepareStatement("delete from user where email='"+u.em+"' and password='"+u.ps+"'");
		UserController.count=ps.executeUpdate();
		ps.close();
		con.close();
	}
}

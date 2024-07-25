package jdbc_user.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class User {
	private int age;
	@Override
	public String toString() {
		return "User:\n  age=" + age + ",\n name= " + name +",\n password= "+password+ ",\n email= " + email + ",\n gender= " + gender + ",\n date of birth= " + d
				+ ",\n place=" + place + ",\n phone=" + phone ;
	}
	private String name,email,gender,place,password;
	private Date d;
	private long phone;
	public String em;
	public String ps;
	public int count;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return d;
	}
	public void setDob(Date d) {
		this.d = d;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public User(String email, String name,String password, long phone,int age, String gender, String place, Date dob) {
		super();
		this.age = age;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.d = dob;
		this.place = place;
		this.phone = phone;
		this.password=password;
	}
	public User() {
		super();
	}
	public ArrayList e =new ArrayList();
	public ArrayList p =new ArrayList();
	
}

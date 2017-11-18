package Users;

import java.io.Serializable;
import java.util.ArrayList;

import college_data.Booking;

/**
 * 
 * @author ISHAAN BASSI
 * @version 1.0
 * 
 *  STORES BASIC DETAILS COMMON TO ALL USERS LIKE NAME, EMAIL, PASSWORD AND TYPE OF USER
 *
 */

public class User  implements Serializable {
	
	protected String name;
	protected String type;
	protected String email;
	protected String password;
	
	public User(String n,String e,String t,String p)
	{
		name=n;
		type=t;
		email=e;
		password=p;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	

}

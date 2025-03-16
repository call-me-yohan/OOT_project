package Classes;

public class User{
	private String username;
	private String password;
	private String usertype;
	
	public User(String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsertype() {
		return usertype;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public boolean login(String username, String password) {
		return (this.username.equals(username)&& this.password.equals(password));
	}
	
}


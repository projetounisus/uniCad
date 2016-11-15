package br.com.uniCad.model.beans;

public class Login extends AbstractBean{
	private String userName;
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Login(int id, String userName, String userPassword) {
		super(id);
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public Login(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public Login() {
		super();
	}
}

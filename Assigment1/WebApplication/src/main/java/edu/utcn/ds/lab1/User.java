package edu.utcn.ds.lab1;


public class User {

	private String username = "";
	private String password = "";
	private String displayName = "";
	private String birthDate;
	private String address="";
	private Double xCoordinate = 0.0;
	private Double yCoordinate = 0.0;
	private String role = "user";
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public User(String username, String password, String displayName,
			String birthDate, String address, Double xCoordinate,
			Double yCoordinate, String role) {
		super();
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.birthDate = birthDate;
		this.address = address;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.role = role;
	}

	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return this.username+" "+this.displayName+" "+this.password+" "+this.role+this.xCoordinate+" "+this.yCoordinate;
	}
}

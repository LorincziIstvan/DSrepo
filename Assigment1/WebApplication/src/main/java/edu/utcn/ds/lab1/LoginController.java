package edu.utcn.ds.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.utcn.ds.lab1.backend.Persistence;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginController {

	private User user = new User();
	private String edituser;
	private List<User> list;
	private String loggedUser;
	private String loggedRole;
	private String timeZone;
	private String dateString;
	private List<String> usernames;
	private List<String> roles= new ArrayList<String>() {{
	    add("admin"); add("user");
	}};

	public String login() throws IOException {
		 Persistence connection=new Persistence();
		if (connection.checkPassword(user)) {

			user = connection.getUserByUsername(user.getUsername());

			if (user.getRole().equals("admin")) {
				loggedUser = user.getUsername();
				loggedRole = "admin";
				return "admin/admin";
			} else {
				
				URL url = new URL("http://localhost:8080/WebService/tz?x="
						+ user.getxCoordinate());
				URLConnection urlConnection = url.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						urlConnection.getInputStream()));
				String line = reader.readLine();
				reader.close();
				this.timeZone=line.substring(line.indexOf("<time>")+6,line.indexOf("</time>"));
				loggedUser = user.getUsername();
				loggedRole = "user";
				return "user/simple_user";
			}
		} else {
			return "failure";
		}

	}
	
	public String logout() throws IOException {
		this.loggedRole="";
		this.loggedUser="";
		return "admin/admin.xhtml";
	}

	public String edit() throws IOException {
		 Persistence connection=new Persistence();
		user=connection.getUserByUsername(edituser);
		dateString=user.getBirthDate();
		return "edituser";
	}
	
	public String editdo() throws IOException {
		Persistence connection=new Persistence();
		user.setBirthDate(toDate(dateString));
		connection.update(user);
		return "admin";
	}
	
	public String delete() throws IOException {
		Persistence connection=new Persistence();
		connection.deleteUser(edituser);
		list=connection.getUsers();
		 this.usernames=new ArrayList<String>();
			for(int i=0;i<list.size();i++)
			{
				this.usernames.add(list.get(i).getUsername());
			}
		
		return "admin/admin";
	}

	public String signup() throws IOException {
		return "signup";
	}
	
	public String insert() throws IOException {
		user=new User();
		return "/signup";
	}

	public String createUser() throws IOException {
		Persistence connection=new Persistence();
		user.setRole("user");
		user.setBirthDate(toDate(dateString));
		connection.insert(user);

		return "index";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String getLoggedRole() {
		return loggedRole;
	}

	public void setLoggedRole(String loggedRole) {
		this.loggedRole = loggedRole;
	}

	public List<User> getList() {
		Persistence connection=new Persistence();
		list = connection.getUsers();
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getEdituser() {
		return edituser;
	}

	public void setEdituser(String edituser) {
		this.edituser = edituser;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
	public List<String> getUsernames() {
		 this.usernames=new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			this.usernames.add(list.get(i).getUsername());
		}
		return this.usernames;
	}

	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	private String toDate(String input) {
		String[] values=input.split("[ /\\,:.]");
		return values[0]+"/"+values[1]+"/"+values[2];
	}
	
}

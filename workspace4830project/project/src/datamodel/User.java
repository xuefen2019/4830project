package datamodel;

public class User {
	private Integer id;
	private String email;
	private String password;
	private String name;

	public  User() {
	}
	public  User(Integer id, String email, String password, String name) {
	      this.id = id;
	      this.email = email;
	      this.password = password;
	      this.name = name;
	}
	public  User(String email, String password, String name) {
	      this.email = email;
	      this.password = password;
	      this.name = name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	   public String toString() {
	      return "User: " + this.id + ", " + this.name + ", " + this.email + ", " + this.password;
	   }
	
	
}

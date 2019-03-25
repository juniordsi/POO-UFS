package application.model;

public class Usuario {
	private String user;
	private String email;
	private String password;
	private String name;
	private String gender;
	private Integer followers;
	private Integer following;
	private String perfil_img;
	private String login;
	
	public Usuario () {
	}
	
	public Usuario (String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
	}
	
	public Usuario (String user, String email, String password, String name, String gender) {
		this.setUser(user);
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setGender(gender);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFollowing() {
		return following;
	}

	public void setFollowing(Integer following) {
		this.following = following;
	}

	public String getPerfil_img() {
		return perfil_img;
	}

	public void setPerfil_img(String perfil_img) {
		this.perfil_img = perfil_img;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}

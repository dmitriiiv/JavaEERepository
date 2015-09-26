package by.agency.travel.hibernate.dao.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "USERS")
public class UserPojo implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "pass")
	private String pass;
	
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "USER_ROLE", 
	joinColumns = @JoinColumn(name = "USER_ID"), 
	inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<RolePojo> roles = new ArrayList<RolePojo>();
	
	public UserPojo(){
	}

	public UserPojo(Integer id, String login, String pass, List<RolePojo> roles) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.roles = roles;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<RolePojo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePojo> roles) {
		this.roles = roles;
	}
}

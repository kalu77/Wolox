package ar.com.genomasoft.fenix.model;

public class user {

	Integer id;
    String name;
    String username;
    String email;
    address address;    
    String phone;
    String websit;
    company company;
    
    
	public user() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsit() {
		return websit;
	}
	public void setWebsit(String websit) {
		this.websit = websit;
	}
	public company getCompany() {
		return company;
	}
	public void setCompany(company company) {
		this.company = company;
	}
    	
    
}

package models;


import java.util.*;

/**
 * 
 */
public class User {
	
    private String username;
    private String password;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
    private Role role;
    private Set<Child> children;

    /**
     * Default constructor
     */
    public User() {
    }
    
    public User(String username, String password, String email, String phone, String first_name, String last_name) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	this.phone = phone;
    	this.first_name = first_name;
    	this.last_name = last_name;
    }
    
    public User(String username, String password, String email, String phone, String first_name, String last_name, Role role) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	this.phone = phone;
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.role = role;
    }
    
    public User(String username, String password, String email, String phone, String first_name, String last_name, Role role, Set<Child> children) {
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	this.phone = phone;
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.role = role;
    	this.children = children;
    }

    /**
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username 
     * @return
     */
    public void setUsername(String username) {
    	this.username = username;
    }

    /**
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getEmail() {
    	return this.email;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * @return
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @param phone 
     * @return
     */
    public void setPhone(String phone) {
    	this.phone = phone;
    }

    /**
     * @return
     */
    public String getFirstName() {
    	return this.first_name;
    }

    /**
     * @return
     */
    public String getLastName() {
       return this.last_name;
    }

    /**
     * @param first_name 
     * @return
     */
    public void setFirstName(String first_name) {
    	this.first_name = first_name;
    }

    /**
     * @param last_name 
     * @return
     */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return
     */
    public Role getRole() {
    	return role;
    }

    /**
     * @return
     */
    public void setRole(Role role) {
    	this.role = role;
    }

    /**
     * @return
     */
    public Set<Child> getChildren() {
        return this.children;
    }

    /**
     * @param children 
     * @return
     */
    public void setChildren(Set<Child> children) {
        this.children = children;
    }

}
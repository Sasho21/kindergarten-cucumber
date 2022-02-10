package models;


import java.util.*;

/**
 * 
 */
public class Role {

	private String code;
    private Set<User> users;
	
    /**
     * Default constructor
     */
    public Role() {
    }
    
    public Role(String code) {
    	this.code = code;
    }
    
    public Role(String code, HashSet<User> users) {
    	this.code = code;
    	this.users = users;
    }

    /**
     * @return
     */
    public String getCode() {       
        return this.code;
    }

    /**
     * @param code 
     * @return
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return
     */
    public Set<User> getUsers() {
    	return this.users;
    }

    /**
     * @param users 
     * @return
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
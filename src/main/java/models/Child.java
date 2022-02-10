package models;


import java.util.*;

/**
 * 
 */
public class Child {
	
	private String first_name;
    private String last_name;
    private String date_of_birth;
    private boolean is_disabled;
    private int working_parents;
    private boolean has_twin;
    private int points;
    private Set<User> parents;
    private Set<Child> siblings;
    private ChildStatus status;
    private int position;

    /**
     * Default constructor
     */
    public Child() {
    }
    
    public Child(String first_name, String last_name, String date_of_birth, boolean is_disabled, int working_parents, boolean has_twin, ChildStatus status) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.date_of_birth = date_of_birth;
    	this.is_disabled = is_disabled;
    	this.working_parents = working_parents;
    	this.has_twin = has_twin;
    	this.status = status;
    }
    
    public Child(String first_name, String last_name, String date_of_birth, boolean is_disabled, int working_parents, boolean has_twin, int points, ChildStatus status) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.date_of_birth = date_of_birth;
    	this.is_disabled = is_disabled;
    	this.working_parents = working_parents;
    	this.has_twin = has_twin;
    	this.points = points;
    	this.status = status;
    }
    
    public Child(String first_name, String last_name, String date_of_birth, boolean is_disabled, int working_parents, boolean has_twin, int points, ChildStatus status, Set<User> parents) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.date_of_birth = date_of_birth;
    	this.is_disabled = is_disabled;
    	this.working_parents = working_parents;
    	this.has_twin = has_twin;
    	this.points = points;
    	this.status = status;
    	this.parents = parents;
    }
    
    public Child(String first_name, String last_name, String date_of_birth, boolean is_disabled, int working_parents, boolean has_twin, ChildStatus status,  Set<User> parents) {
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.date_of_birth = date_of_birth;
    	this.is_disabled = is_disabled;
    	this.working_parents = working_parents;
    	this.has_twin = has_twin;
    	this.status = status;
    	this.parents = parents;
    }

    /**
     * @return
     */
    public String getFirstName() {      
        return this.first_name;
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
    public String getLastName() {
        return this.last_name;
    }

    /**
     * @return
     */
    public String getDateOfBirth() {
        return this.date_of_birth;
    }

    /**
     * @param date_of_birth 
     * @return
     */
    public void setDateOfBirth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * @return
     */
    public boolean getIsDisabled() {
        return this.is_disabled;
    }

    /**
     * @param disabled 
     * @return
     */
    public void setIsDisabled(boolean is_disabled) {
        this.is_disabled = is_disabled;
    }

    /**
     * @return
     */
    public int getWorkingParents() {
        return this.working_parents;
    }

    /**
     * @param count 
     * @return
     */
    public void setWorkingParents(int count) {
    	this.working_parents = count;
    }

    /**
     * @return
     */
    public boolean getHasTwin() {
        return this.has_twin;
    }

    /**
     * @param has_twin 
     * @return
     */
    public void setHasTwin(boolean has_twin) {
        this.has_twin = has_twin;
    }

    /**
     * @return
     */
    public Set<User> getParents() {
        if (null == parents) {
        	parents = new HashSet<User>();
        }
        
        return parents;
    }

    /**
     * @param parents 
     * @return
     */
    public void setParent(Set<User> parents) {
        this.parents = parents;
    }

    /**
     * @return
     */
    public Set<Child> getSiblings() {
        if (null == siblings) {
        	siblings = new HashSet<Child>();
        }
        
        return siblings;
    }

    /**
     * @param children 
     * @return
     */
    public void setSiblings(Set<Child> children) {
        siblings = children;
    }

    /**
     * @return
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * @param points 
     * @return
     */
    public void setPoints(int points) {
        this.points = points;
    }
    
    public ChildStatus getStatus() {
    	return this.status;
    }
    
    public void setStatus(ChildStatus status) {
    	this.status = status;
    }
    
    public int getPosition() {
    	return this.position;
    }
    
    public void setPosition(int position) {
    	this.position = position;
    }
}
package models;


import java.util.*;

/**
 * 
 */
public class ChildStatus {

    private String status;
    private Set<Child> children;
	
    /**
     * Default constructor
     */
    public ChildStatus() {
    }
    
    public ChildStatus(String status) {
    	this.status = status;
    }
    
    public ChildStatus(String status, HashSet<Child> children) {
    	this.status = status;
    	this.children = children;
    }

    /**
     * @return
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status 
     * @return
     */
    public void setStatus(String status) {
    	this.status = status;
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
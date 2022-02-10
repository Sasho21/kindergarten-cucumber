package ModelForms;

import java.util.HashSet;
import java.util.Set;

import models.Child;
import models.User;
import services.PlacementService;

public class ChildForm {
	private String first_name;
    private String last_name;
    private String date_of_birth;
    private boolean is_disabled;
    private int working_parents;
    private boolean has_twin;
    private String parent_phone;

    private String message;

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
     * @param date_of_birth 
     * @return
     */
    public void setDateOfBirth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    
    /**
     * @param disabled 
     * @return
     */
    public void setIsDisabled(boolean is_disabled) {
        this.is_disabled = is_disabled;
    }

    /**
     * @param count 
     * @return
     */
    public void setWorkingParents(int count) {
    	this.working_parents = count;
    }

    /**
     * @param has_twin 
     * @return
     */
    public void setHasTwin(boolean has_twin) {
        this.has_twin = has_twin;
    }
    
    public String getMessage() {
    	return message;
    }
    
    public void setParentPhone(String phone) {
    	parent_phone = phone;
    }
    
    public void clickRegisterChildButton() {
    	message = PlacementService.registerChild(first_name, last_name, date_of_birth, is_disabled, working_parents, has_twin);
    }
    
    public void adminClickRegisterChildButton() {
    	message = PlacementService.registerChild(first_name, last_name, date_of_birth, is_disabled, working_parents, has_twin, parent_phone);
    }
}

package ModelForms;

import services.RegisterService;

public class RegisterForm {
	
	private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
    private String registerMessage;

    /**
     * @param username 
     * @return
     */
    public void setUsername(String username) {
    	this.username = username;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @param password 
     * @return
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * @param phone 
     * @return
     */
    public void setPhone(String phone) {
    	this.phone = phone;
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
    
    public String getRegisterMessage() {
    	return this.registerMessage;
    }
    
    public void clickRegisterButton() {
    	registerMessage = RegisterService.register(username, password, confirmPassword, email, phone, first_name, last_name);
    }
}

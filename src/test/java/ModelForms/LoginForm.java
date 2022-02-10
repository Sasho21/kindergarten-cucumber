package ModelForms;

import services.LoginService;

public class LoginForm {
	private String username;
    private String password;
    private String loginMessage;

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
    
    public String getLoginMessage() {
    	return loginMessage;
    }
    
    public void clickLoginButton() {
    	this.loginMessage = LoginService.login(username, password);
    }
}

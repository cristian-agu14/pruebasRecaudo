package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class LoginEdeq extends PageBase{

	public LoginEdeq(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}
	
	//WebElements
	
		//Elemento web User Name
		@FindBy(how=How.NAME, using = "user")
		private WebElement inputUserName;
		//Elemento web Password
		@FindBy(how=How.NAME, using = "password")
		private WebElement inputPassword;
		//Elemento web User Name
		//@FindBy(how=How.NAME, using = "login")
		@FindBy(how = How.CLASS_NAME, using= "btn btn-success col-md-4 col-md-offset-4")
		private WebElement buttonSingIn;
		
		@FindBy(how = How.CLASS_NAME, using="logout")
		private  WebElement btnCerrarSesion;
		
		

		

		@FindBy(how=How.LINK_TEXT, using = "your destination")
		private WebElement lnkDestination;
		@FindBy(how=How.LINK_TEXT, using = "featured vacation destinations")
		private WebElement lnkVacation;
		@FindBy(how=How.LINK_TEXT, using = "Register  here")
		private WebElement lnkRegister;

		//Getters
		
		public WebElement getInputUserName() {
			return inputUserName;
		}
		public WebElement getInputPassword() {
			return inputPassword;
		}
		public WebElement getButtonSingIn() {
			return buttonSingIn;
		}
		public WebElement getLnkDestination() {
			return lnkDestination;
		}
		public WebElement getLnkVacation() {
			return lnkVacation;
		}
		public WebElement getLnkRegister() {
			return lnkRegister;
		}
		public WebElement getBtnCerrarSesion() {
			return btnCerrarSesion;
		}
		public void setBtnCerrarSesion(WebElement btnCerrarSesion) {
			this.btnCerrarSesion = btnCerrarSesion;
		}
		public void setInputUserName(WebElement inputUserName) {
			this.inputUserName = inputUserName;
		}
		public void setInputPassword(WebElement inputPassword) {
			this.inputPassword = inputPassword;
		}
		public void setButtonSingIn(WebElement buttonSingIn) {
			this.buttonSingIn = buttonSingIn;
		}
		public void setLnkDestination(WebElement lnkDestination) {
			this.lnkDestination = lnkDestination;
		}
		public void setLnkVacation(WebElement lnkVacation) {
			this.lnkVacation = lnkVacation;
		}
		public void setLnkRegister(WebElement lnkRegister) {
			this.lnkRegister = lnkRegister;}
		
		public void loginMercuryTours(String userName, String password){
			sendText(inputUserName, userName);
			sendText(inputPassword, password);
			clickButtonLink(buttonSingIn);
		}
	

}

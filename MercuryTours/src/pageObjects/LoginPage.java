package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class LoginPage extends PageBase{

	/**
	 * @param driver
	 * @param pageTitle
	 */
	public LoginPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
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
	@FindBy(how=How.XPATH, using = "//html/body/form/div/div/div[2]/div[2]/input")
	private WebElement buttonSingIn;
	
	
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
	
	public void loginMercuryTours(String userName, String password){
		sendText(inputUserName, userName);
		sendText(inputPassword, password);
		clickButtonLink(buttonSingIn);
	}
}

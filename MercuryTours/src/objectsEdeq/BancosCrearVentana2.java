package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class BancosCrearVentana2 extends PageBase{

	public BancosCrearVentana2(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}
	
	public BancosCrearVentana2() {
		super();
	}
	
	public void enviarInformacion(String nombreBanco) {
		System.out.println("----------->" + nombreBanco);
		sendText(cajaTextoNombre, nombreBanco);
		clickButtonLink(btnCrear);	
	}
	
	//Caja de texto para ingresar el nombre del banco a crear
	@FindBy(how = How.ID, using="NOMBRE")
	private WebElement cajaTextoNombre;
	
	//Boton para ingresar el banco a la base de datos
	@FindBy (how = How.CLASS_NAME, using="btn btn-default send")
	private WebElement btnCrear;

}

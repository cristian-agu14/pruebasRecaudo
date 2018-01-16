package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class PagoObligaciones extends PageBase {

	int valorAPagar = 0;

	public PagoObligaciones(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * Metodo que realiza el pago con solo efectivo de un cupon
	 * 
	 * @return true si el pago fue correcto (valorAPagar - Dinero = 0)
	 * @return false si el pago no es el correcto (devuelta != 0)
	 */
	public boolean pagarSoloEfectivo(String valorCupon) {

		
		//clickButtonLink(btnMenu);
		//clickButtonLink(opcionPagos);
		//valorCupon = getText(valorPagar);
		//WebElement webElementValorCupon =  driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/input"));
		//valorCupon = webElementValorCupon.getText();
		//valorCupon = cajaTextoValorDesembolso.getText(); 
		System.out.println("--------------->" + valorCupon + "<---------------------");
		sendText(cajaTextoValorDesembolso, valorCupon);
		clickButtonLink(btnGuardarDesembolso);
		//devuelta = getText(valorDevuelta);
		
		// if (devuelta.equals("0")) {
		// return true;
		// } else {
		// return false;
		// }
 		return true;

	}

	/**
	 * Boton del menu principal
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnMenu;

	/**
	 * Boton para ingresar a la opcion de pagos
	 */
	@FindBy(how = How.ID, using = "menu14")
	private WebElement opcionPagos;

	/**
	 * Caja de texto en la que se muestra el valor que se debe pagar
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/input")
	private WebElement valorPagar;

	/**
	 * Caja de texto en la que se debe de ingresar el valor a pagar
	 */
	@FindBy(how = How.ID, using = "Valor")
	private WebElement cajaTextoValorDesembolso; 

	/**
	 * Caja de texto en donde se muestra el valor de la devuelta
	 */
	@FindBy(how = How.ID, using = "devuelta")
	private WebElement valorDevuelta;

	/**
	 * Boton para realizar el desembolso del dinero del valor del cupon
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/fieldset/div[2]/div/form/div/div/div/button")
	private WebElement btnGuardarDesembolso;
}

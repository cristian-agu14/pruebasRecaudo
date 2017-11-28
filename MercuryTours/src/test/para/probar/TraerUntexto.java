package test.para.probar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TraerUntexto extends TestBase {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://13.57.9.157/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testVerifyBodyText() throws Exception {
		driver.get(baseUrl + "/recaudos/");
		System.out.println(
				"--------------->" + driver.findElement(By.className("bienvenido")).getText() + "<--------------");
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user")).sendKeys("123");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("1022");
		// driver.findElement(By.xpath("//input[@value='Iniciar Sesi�n']")).click();

		try {
			assertEquals((driver.findElement(By.className("bienvenido")).getText()), "Bienvenido");// ojo con esto se
																									// puede capturar un
																									// texto, comprobar
																									// que funcione
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	// private boolean isElementPresent(By by) {
	// try {
	// driver.findElement(by);
	// return true;
	// } catch (NoSuchElementException e) {
	// return false;
	// }
	// }
	//
	// private boolean isAlertPresent() {
	// try {
	// driver.switchTo().alert();
	// return true;
	// } catch (NoAlertPresentException e) {
	// return false;
	// }
	// }
	//
	// private String closeAlertAndGetItsText() {
	// try {
	// Alert alert = driver.switchTo().alert();
	// String alertText = alert.getText();
	// if (acceptNextAlert) {
	// alert.accept();
	// } else {
	// alert.dismiss();
	// }
	// return alertText;
	// } finally {
	// acceptNextAlert = true;
	// }
	// }

}

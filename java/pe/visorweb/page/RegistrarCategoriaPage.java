package pe.visorweb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrarCategoriaPage {

	private By txtNombre = By.id("txtNombre");
	private By btnGuardar = By.id("btnGuardar");
	private By btnVolver = By.id("btnVolver");
	private By lblMensaje = By.id("messages");
	
	private WebDriver driver;

	public RegistrarCategoriaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public MantenimientoCategoriaPage volver() {
		driver.findElement(btnVolver).click();
		return new MantenimientoCategoriaPage(driver);
	}
	
	public String registrarCategoria(String nombreCategoria) {
		driver.findElement(txtNombre).clear();
		driver.findElement(txtNombre).sendKeys(nombreCategoria);
		driver.findElement(btnGuardar).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return driver.findElement(lblMensaje).getText();
		
	}
	
}

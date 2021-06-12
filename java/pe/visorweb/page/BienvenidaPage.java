package pe.visorweb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.visorweb.menu.MenuPrincipal;

public class BienvenidaPage {

	private By lblMensajeBienvenida = By.xpath("/html/body/section/div[2]/div/div/div/div/div/div[1]/div/div");
	
	private WebDriver driver;
	
	private MenuPrincipal menuPrincipal;
	
	public BienvenidaPage(WebDriver driver) {
		this.driver = driver;
		this.menuPrincipal = new MenuPrincipal(driver);
	}
	
	public String getMensajeBienvenida() {
		return driver.findElement(lblMensajeBienvenida).getText();
	}
	
	public MantenimientoCategoriaPage irMantenimientoCategoria() {
		return menuPrincipal.irMantenimientoCategoriaPage();
	}
	
}

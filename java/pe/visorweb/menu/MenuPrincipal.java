package pe.visorweb.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.visorweb.page.MantenimientoCategoriaPage;

public class MenuPrincipal {

	private By linkMenuHamburguesa = By.xpath("/html/body/section/div[1]/div");
	private By linkModuloAlmacen = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
	private By linkMantenimientoCategoria = By.linkText("Mnt. de Categoría");
	
	private WebDriver driver;
	
	public MenuPrincipal(WebDriver driver) {
		this.driver = driver;
	}
	
	public MantenimientoCategoriaPage irMantenimientoCategoriaPage() {
		try {
			Thread.sleep(2000);
			driver.findElement(linkMenuHamburguesa).click();
			Thread.sleep(2000);
			driver.findElement(linkModuloAlmacen).click();
			Thread.sleep(2000);
			driver.findElement(linkMantenimientoCategoria).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new MantenimientoCategoriaPage(driver);
	}
	
}

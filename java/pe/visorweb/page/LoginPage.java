package pe.visorweb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private By txtUsuario = By.id("txtUsuario");
	private By txtClave = By.id("txtClave");
	private By btnIniciarSesion = By.id("btnIniciarSesion");
	
	private WebDriver driver;
	private String url;

	private BienvenidaPage bienvenidaPage;
	
	public LoginPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}
	
	public void cargarPaginaLogin() {
		driver.get(url);
	}
	
	public void iniciarSesion(String usuario, String clave) {
		driver.findElement(txtUsuario).sendKeys(usuario);
		driver.findElement(txtClave).sendKeys(clave);
		driver.findElement(btnIniciarSesion).click();
		
	}
	
	public BienvenidaPage getBienvenidaPage() {
		if( bienvenidaPage == null ) {
			bienvenidaPage = new BienvenidaPage(driver);
		}
		return bienvenidaPage;
	}
	

}

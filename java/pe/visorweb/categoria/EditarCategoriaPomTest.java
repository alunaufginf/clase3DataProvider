package pe.visorweb.categoria;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pe.visorweb.driver.CrearDriver;
import pe.visorweb.driver.tipos.Navegador;
import pe.visorweb.page.BienvenidaPage;
import pe.visorweb.page.EditarCategoriaPage;
import pe.visorweb.page.LoginPage;
import pe.visorweb.page.MantenimientoCategoriaPage;
import pe.visorweb.page.RegistrarCategoriaPage;

public class EditarCategoriaPomTest {

	private static WebDriver driver;
	private String url = "http://localhost:8080/VisorWeb/index.xhtml";
	private LoginPage loginPage;
	private BienvenidaPage bienvenidaPage;
	private MantenimientoCategoriaPage mantenimientoCategoriaPage;
	private EditarCategoriaPage editarCategoriaPage;
	
	@BeforeTest
	public static void configurarDriver() {
		driver = CrearDriver.getDriver(Navegador.CHROME);
	}
	
	@AfterTest
	public static void cerrarDriver() {
		driver.close();
	}
	
	@Test
  	public void testEditarCategoriaExitosa() {
		
		loginPage = new LoginPage(driver, url);
		loginPage.cargarPaginaLogin();
		loginPage.iniciarSesion("admin", "clave");
		
		bienvenidaPage = loginPage.getBienvenidaPage();
		mantenimientoCategoriaPage = bienvenidaPage.irMantenimientoCategoria();
		
		editarCategoriaPage = mantenimientoCategoriaPage
									.cargarPaginaEditarCategoria("CATEGORIA SELENIUM");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}




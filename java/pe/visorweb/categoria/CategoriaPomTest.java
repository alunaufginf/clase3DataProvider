package pe.visorweb.categoria;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pe.visorweb.driver.CrearDriver;
import pe.visorweb.driver.tipos.Navegador;
import pe.visorweb.page.BienvenidaPage;
import pe.visorweb.page.LoginPage;
import pe.visorweb.page.MantenimientoCategoriaPage;
import pe.visorweb.page.RegistrarCategoriaPage;

public class CategoriaPomTest {

	private static WebDriver driver;
	private String url = "http://localhost:8080/VisorWeb/index.xhtml";
	private LoginPage loginPage;
	private BienvenidaPage bienvenidaPage;
	private MantenimientoCategoriaPage mantenimientoCategoriaPage;
	private RegistrarCategoriaPage registrarCategoriaPage;
	
	@BeforeTest
	public static void configurarDriver() {
		driver = CrearDriver.getDriver(Navegador.CHROME);
	}
	
	@AfterTest
	public static void cerrarDriver() {
		driver.close();
	}
	
	@Test
  	public void testInsertarCategoriaExitosa() {
		
		loginPage = new LoginPage(driver, url);
		loginPage.cargarPaginaLogin();
		loginPage.iniciarSesion("admin", "clave");
		
		bienvenidaPage = loginPage.getBienvenidaPage();
		String mensajeBienvenidaEsperado = "Bienvenido(a) al Sistema Visor de Almacén";
		String mensajeBienvenidaObtenido = bienvenidaPage.getMensajeBienvenida();
		assertEquals(mensajeBienvenidaObtenido, mensajeBienvenidaEsperado);
		
		mantenimientoCategoriaPage = bienvenidaPage.irMantenimientoCategoria();
		registrarCategoriaPage = mantenimientoCategoriaPage.cargarPaginaRegistrarCategoria();
		
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = registrarCategoriaPage.registrarCategoria("Selenium POM");
		assertEquals(mensajeObtenido, mensajeEsperado);
		
	}
	
	@Test(dependsOnMethods = {"testInsertarCategoriaExitosa"} )
  	public void testInsertarCategoriaDatosVacios() {
		
		loginPage = new LoginPage(driver, url);
		loginPage.cargarPaginaLogin();
		loginPage.iniciarSesion("admin", "clave");
		
		bienvenidaPage = loginPage.getBienvenidaPage();
		mantenimientoCategoriaPage = bienvenidaPage.irMantenimientoCategoria();
		registrarCategoriaPage = mantenimientoCategoriaPage.cargarPaginaRegistrarCategoria();
		
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = registrarCategoriaPage.registrarCategoria("");
		assertEquals(mensajeObtenido, mensajeEsperado);

	}
	
	
	
}




package pe.visorweb.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MantenimientoCategoriaPage {

	private By btnNuevo = By.id("btnNuevo");
	private By txtFiltro = By.id("txtFiltro");
	private By btnFiltrar = By.id("btnFiltrar");
	private By btnEditar = By.id("btnActualizar");
	private By tblCategoriaDatos = By.id("tablaCategorias_data");
	
	private List<WebElement> filas;
	
	private WebDriver driver;

	public MantenimientoCategoriaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> filtrar(String filtro) {
		driver.findElement(txtFiltro).sendKeys(filtro);
		driver.findElement(btnFiltrar).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement datosCategoria = driver.findElement(tblCategoriaDatos);
		filas = datosCategoria.findElements(By.tagName("tr"));
		
		return filas;
	}
	
	public WebElement seleccionarFilaPorNombre(String nombre) {
		List<WebElement> filas = filtrar(nombre);
		for(WebElement fila : filas) {
			List<WebElement> columnas = fila.findElements(By.tagName("td"));
			WebElement columnaNombre = columnas.get(1);
			if( columnaNombre.getText().trim().equalsIgnoreCase(nombre) ) {
				fila.click();
				return fila;
			}
		}
		return null;
	}
	
	public EditarCategoriaPage cargarPaginaEditarCategoria(String nombreCategoriaEditar) {
		seleccionarFilaPorNombre(nombreCategoriaEditar);
		driver.findElement(btnEditar).click();
		return new EditarCategoriaPage(driver);
	}
	
	public RegistrarCategoriaPage cargarPaginaRegistrarCategoria() {
		driver.findElement(btnNuevo).click();
		return new RegistrarCategoriaPage(driver);
	}
	
}

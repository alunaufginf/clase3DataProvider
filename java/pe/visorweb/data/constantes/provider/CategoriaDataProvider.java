package pe.visorweb.data.provider;

import org.apache.commons.lang3.NotImplementedException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;

import pe.visorweb.data.constantes.TipoDato;
import pe.visorweb.data.excel.CategoriaExcel;

@Guice
public class CategoriaDataProvider {
	
	@DataProvider(name = "datosRegistrarCategoria")
	public static Object[][] obtenerDatosRegistrarCategoria(ITestContext context) {
		
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		
		if( TipoDato.EXCEL.equalsIgnoreCase(fuenteDatos) ) {
			return CategoriaExcel.leerCategorias(rutaArchivo);
		} else if ( TipoDato.BD.equalsIgnoreCase(fuenteDatos) ) {
			throw new NotImplementedException("Fuente de datos no implementada");
		}
		
		throw new IllegalArgumentException("Fuente de datos no encontrada");
		
	}
	
	
}

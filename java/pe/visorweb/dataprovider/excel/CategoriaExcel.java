package pe.visorweb.dataprovider.excel;

import com.codoid.products.fillo.*;

public class CategoriaExcel {
	
	public static Object [][] leerCategorias(String rutaArchivo){
		
		String consulta = "SELECT * FROM hoja1 WHERE FlagEjecucion = 'S'";
		
		try {
			
			Fillo fillo = new Fillo();
			Connection conexion = fillo.getConnection(rutaArchivo);
			Recordset resultados = conexion.executeQuery(consulta);
			
			int fila = 0;
			Object [][] datos = new Object[resultados.getCount()][4];
					
			while (resultados.next()) {
				
				datos[fila][0] = resultados.getField("Usuario");
				datos[fila][1] = resultados.getField("Clave");
				datos[fila][2] = resultados.getField("NombreCategoria");	
				datos[fila][3] = resultados.getField("MensajeEsperado");	
				fila++;
			}
			
			return datos;
			
		} catch (Exception e) {
			throw new RuntimeException("Error al leer el archivo excel",e);
		}
	}

}

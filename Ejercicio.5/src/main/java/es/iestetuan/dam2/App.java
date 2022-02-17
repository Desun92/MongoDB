package es.iestetuan.dam2;

import es.iestetuan.dam2.procesamiento.LineaJSON;
import es.iestetuan.dam2.utilidades.ParseoJson;

public class App {

	public static void main(String[] args) {
		
		try {
			ParseoJson parseoJson = new ParseoJson();
			LineaJSON[] listaLineasJson = parseoJson.obtenerLineas();
			for(LineaJSON linea : listaLineasJson) {
				System.out.println(linea);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

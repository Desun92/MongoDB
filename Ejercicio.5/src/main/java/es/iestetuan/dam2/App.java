package es.iestetuan.dam2;

import es.iestetuan.dam2.dao.mongoDB.LineaMongoDB;
import es.iestetuan.dam2.dao.vo.Color;
import es.iestetuan.dam2.dao.vo.Linea;
import es.iestetuan.dam2.procesamiento.LineaJSON;
import es.iestetuan.dam2.procesamiento.LineaXML;
import es.iestetuan.dam2.utilidades.ParseoJson;
import es.iestetuan.dam2.utilidades.ParseoXML;

public class App {

	public static void main(String[] args) {
		
		try {
			
			ParseoJson parseoJson = new ParseoJson();
			ParseoXML parseoXML = new ParseoXML();
			LineaJSON[] listaLineasJson = parseoJson.obtenerLineas();
			LineaMongoDB operacionLinea = new LineaMongoDB();
			
			//CREAR LOS REGISTROS
			/*for(LineaJSON lineaJson : listaLineasJson) {
				
				Linea linea = new Linea();
				Color color = new Color();
				color.setCodigoColor(lineaJson.getColor().getCodigoColor());
				color.setNombre(lineaJson.getColor().getNombre());
				color.setCodigoHexadecimal(lineaJson.getColor().getCodigoHexadecimal());
				
				linea.setCodigoLinea(lineaJson.getCodigoLinea());
				linea.setNombreCorto(lineaJson.getNombreCorto());
				linea.setNombreLargo(lineaJson.getNombreLargo());
				linea.setColor(color);
				linea.setKilometros(lineaJson.getKilometros());
				linea.setUrl(lineaJson.getUrl());
				operacionLinea.crear(linea);
			}*/
			
			//BORRAR UN REGISTRO
			/*Linea linea = new Linea();
			
			linea.setCodigoLinea(5);
			operacionLinea.borrar(linea);*/
			
			//ACTUALIZAR
			/*LineaXML lineaXML = new LineaXML();
			lineaXML = parseoXML.obtenerLineaXML();
			Linea linea = new Linea();
			Color color = new Color();
			
			color.setCodigoColor(lineaXML.getColor().getCodigoColor());
			color.setNombre(lineaXML.getColor().getNombre());
			color.setCodigoHexadecimal(lineaXML.getColor().getCodigoHexadecimal());
			
			linea.setCodigoLinea(lineaXML.getCodigoLinea());
			linea.setNombreCorto(lineaXML.getNombreCorto());
			linea.setNombreLargo(lineaXML.getNombreLargo());
			linea.setColor(color);
			linea.setKilometros(lineaXML.getKilometros());
			linea.setUrl(lineaXML.getUrl());
			
			operacionLinea.actualizar(linea, 3);*/
			
			//CONSULTAR POR ID
			/*Linea linea = operacionLinea.consultarPorID(8);
			System.out.println(linea);*/
			
			//LISTA LINEAS
			/*List<Linea> listaLineas = operacionLinea.consultarLineas();
			for(Linea linea : listaLineas) {
				System.out.println(linea);
			}*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

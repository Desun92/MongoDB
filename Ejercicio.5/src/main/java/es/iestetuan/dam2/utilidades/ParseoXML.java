package es.iestetuan.dam2.utilidades;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.iestetuan.dam2.procesamiento.LineaXML;

public class ParseoXML {
	
	public LineaXML obtenerLineaXML() {
	
		LineaXML lineaXML=null;
		ObjectMapper mapper = new XmlMapper();
		HttpClient client = HttpClient.newHttpClient();
		URI uri = URI.create("http://dam2.actividad.cf:55555/rest/lineas/4");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String result = response.body();
			lineaXML = mapper.readValue(result, LineaXML.class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lineaXML;
	}
}


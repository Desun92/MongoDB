package es.iestetuan.dam2.utilidades;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import es.iestetuan.dam2.procesamiento.LineaJSON;

public class ParseoJson {
	
	public LineaJSON[] obtenerLineas() {
		
		LineaJSON[] listaLineasJson=null;
		ObjectMapper mapper = new JsonMapper();
		HttpClient client = HttpClient.newHttpClient();
		URI uri = URI.create("http://dam2.actividad.cf:55555/rest/lineas");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String result = response.body();
			listaLineasJson = mapper.readValue(result, LineaJSON[].class);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listaLineasJson;
	}

}

package es.iestetuan.dam2.procesamiento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaJSON {
	
	@JsonProperty("codigo_linea_json")
	private int codigoLinea;
	
	@JsonProperty("nombre_corto_json")
	private String nombreCorto;
	
	@JsonProperty("nombre_largo_json")
	private String nombreLargo;
	
	@JsonProperty("color_linea")
	private ColorJSON color;
	
	@JsonProperty("kilometros_json")
	private float kilometros;
	
	@JsonProperty("url_imagen_linea_json")
	private String url;

}

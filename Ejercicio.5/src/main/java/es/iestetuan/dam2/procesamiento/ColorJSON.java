package es.iestetuan.dam2.procesamiento;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColorJSON {
	
	@JsonProperty("codigo_color_json")
	private int codigoColor;
	
	@JsonProperty("nombre_json")
	private String nombre;
	
	@JsonProperty("codigo_hexadecimal_json")
	private String codigoHexadecimal;

}

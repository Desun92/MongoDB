package es.iestetuan.dam2.procesamiento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColorXML {
	
	@JacksonXmlProperty(isAttribute=true, localName="cod_color_xml")
	private int codigoColor;
	
	@JacksonXmlProperty(localName="nombre_xml")
	private String nombre;
	
	@JacksonXmlProperty(localName="cod_hexadecimal_xml")
	private String codigoHexadecimal;

}

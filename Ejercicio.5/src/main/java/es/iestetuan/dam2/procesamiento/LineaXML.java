package es.iestetuan.dam2.procesamiento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaXML {
	
	@JacksonXmlProperty(isAttribute=true, localName="codigo_linea_xml")
	private int codigoLinea;
	
	@JacksonXmlProperty(localName="nombre_corto_xml")
	private String nombreCorto;
	
	@JacksonXmlProperty(localName="nombre_largo_xml")
	private String nombreLargo;
	
	@JacksonXmlProperty(localName="color_linea")
	private ColorXML color;
	
	@JacksonXmlProperty(localName="kilometros_xml")
	private float kilometros;
	
	@JacksonXmlProperty(localName="url_imagen_linea_xml")
	private String url;

}

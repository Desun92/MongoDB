package es.iestetuan.dam2.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Linea {
	
	private int codigoLinea;
	private String nombreCorto;
	private String nombreLargo;
	private Color color;
	private float kilometros;
	private String url;

}

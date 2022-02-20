package es.iestetuan.dam2.dao;

import java.util.List;

import es.iestetuan.dam2.dao.vo.Color;

public interface IColor {
	
	public void crear(Color color);
	public void borrar(Color color);
	public void actualizar(Color color);
	public Color consultarPorID();
	public List<Color> consultarLineas();


}

package es.iestetuan.dam2.dao;

import java.util.List;

import es.iestetuan.dam2.dao.vo.Linea;

public interface ILinea {
	
	public void crear(Linea linea);
	public void borrar(Linea linea);
	public void actualizar(Linea linea);
	public Linea consultarPorID();
	public List<Linea> consultarLineas();

}

package es.iestetuan.dam2.dao.mongoDB;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.dam2.dao.IColor;
import es.iestetuan.dam2.dao.vo.Color;

public class ColorMongoDB implements IColor{

	public void crear(Color color) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		
		Document document = new Document();
		document.put("_id", color.getCodigoColor());
		document.put("nombre", color.getNombre());
		document.put("codigoHexadecimal",color.getCodigoHexadecimal());
		
		tablaLineas.insertOne(document);
	}

	public void borrar(Color color) {
		
		
	}

	public void actualizar(Color color) {
		
		
	}

	public Color consultarPorID() {
		
		return null;
	}

	public List<Color> consultarLineas() {
		
		return null;
	}

}

package es.iestetuan.dam2.dao.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.dam2.dao.ILinea;
import es.iestetuan.dam2.dao.vo.Linea;

public class LineaMongoDB implements ILinea{

	public void crear(Linea linea) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");

		Document colorDocument = new Document();
		colorDocument.put("_id", linea.getColor().getCodigoColor());
		colorDocument.put("nombre", linea.getColor().getNombre());
		colorDocument.put("codigoHexadecimal", linea.getColor().getCodigoHexadecimal());
		
		Document lineaDocument = new Document();
		lineaDocument.put("_id", linea.getCodigoLinea());
		lineaDocument.put("nombreCorto", linea.getNombreCorto());
		lineaDocument.put("nombreLargo", linea.getNombreLargo());
		lineaDocument.append("color", colorDocument);
		lineaDocument.put("kilometros", linea.getKilometros());
		lineaDocument.put("url", linea.getUrl());
		
		tablaLineas.insertOne(lineaDocument);
	}

	public void borrar(Linea linea) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		
		Document lineaDocument = new Document();
		lineaDocument.put("_id", linea.getCodigoLinea());
		
		tablaLineas.findOneAndDelete(lineaDocument);
	}

	public void actualizar(Linea linea) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		
		Document colorDocument = new Document();
		colorDocument.put("_id", linea.getColor().getCodigoColor());
		colorDocument.put("nombre", linea.getColor().getNombre());
		colorDocument.put("codigoHexadecimal", linea.getColor().getCodigoHexadecimal());
		
		Document lineaDocument = new Document();
		lineaDocument.put("_id", linea.getCodigoLinea());
		lineaDocument.put("nombreCorto", linea.getNombreCorto());
		lineaDocument.put("nombreLargo", linea.getNombreLargo());
		lineaDocument.append("color", colorDocument);
		lineaDocument.put("kilometros", linea.getKilometros());
		lineaDocument.put("url", linea.getUrl());
		
		tablaLineas.updateOne(lineaDocument, lineaDocument);
	}

	public Linea consultarPorID() {

		Linea linea = new Linea();
		return linea;
	}

	public List<Linea> consultarLineas() {
		
		List<Linea> listaLineas = new ArrayList<Linea>();
		return listaLineas;
	}

}

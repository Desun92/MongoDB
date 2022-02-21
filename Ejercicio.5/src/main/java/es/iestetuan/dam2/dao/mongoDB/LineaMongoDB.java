package es.iestetuan.dam2.dao.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.dam2.dao.ILinea;
import es.iestetuan.dam2.dao.vo.Color;
import es.iestetuan.dam2.dao.vo.Linea;
import es.iestetuan.dam2.procesamiento.ColorJSON;

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

	public void actualizar(Linea linea, int codLineaActualizar) {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		
		Document docFiltro = new Document("_id",codLineaActualizar);
		
		Document colorDocument = new Document();
		colorDocument.put("_id", linea.getColor().getCodigoColor());
		colorDocument.put("nombre", linea.getColor().getNombre());
		colorDocument.put("codigoHexadecimal", linea.getColor().getCodigoHexadecimal());
		
		Document lineaDocument = new Document();
		//lineaDocument.put("_id", linea.getCodigoLinea());
		lineaDocument.put("nombreCorto", linea.getNombreCorto());
		lineaDocument.put("nombreLargo", linea.getNombreLargo());
		lineaDocument.append("color", colorDocument);
		lineaDocument.put("kilometros", linea.getKilometros());
		lineaDocument.put("url", linea.getUrl());
		
		tablaLineas.replaceOne(docFiltro, lineaDocument);
	}

	public Linea consultarPorID(int id) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		
		Document docFiltro = new Document("_id",id);
		Document doc = tablaLineas.find(docFiltro).first();
		Document docColor = (Document) doc.get("color");
		
		Linea linea = new Linea();
		ColorJSON colorJson = new ColorJSON(docColor.getInteger("_id"),docColor.getString("nombre"),docColor.getString("codigoHexadecimal"));
		
		Color color = new Color();
		color.setCodigoColor(colorJson.getCodigoColor());
		color.setNombre(colorJson.getNombre());
		color.setCodigoHexadecimal(colorJson.getCodigoHexadecimal());
		
		linea.setCodigoLinea(doc.getInteger("_id"));
		linea.setNombreCorto(doc.getString("nombreCorto"));
		linea.setNombreLargo(doc.getString("nombreLargo"));
		linea.setColor(color);
		linea.setKilometros(Float.parseFloat(doc.getDouble("kilometros").toString()));
		linea.setUrl(doc.getString("url"));
		
		return linea;
	}

	public List<Linea> consultarLineas() {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDB= mongoClient.getDatabase("LineaMetro");
		MongoCollection<Document> tablaLineas = mongoDB.getCollection("Lineas");
		List<Linea> listaLineas = new ArrayList<Linea>();
		
		FindIterable<Document> lineasDocument = tablaLineas.find();
		
		for(Document doc : lineasDocument) {
			Linea linea = new Linea();
			Color color = new Color();
			Document docColor = (Document) doc.get("color");
			
			color.setCodigoColor(docColor.getInteger("_id"));
			color.setNombre(docColor.getString("nombre"));
			color.setCodigoHexadecimal(docColor.getString("codigoHexadecimal"));
			
			linea.setCodigoLinea(doc.getInteger("_id"));
			linea.setNombreCorto(doc.getString("nombreCorto"));
			linea.setNombreLargo(doc.getString("nombreLargo"));
			linea.setColor(color);
			linea.setKilometros(Float.parseFloat(doc.getDouble("kilometros").toString()));
			linea.setUrl(doc.getString("url"));
			listaLineas.add(linea);
		}
		
		return listaLineas;
	}

}

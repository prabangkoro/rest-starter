package hello;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;

@SpringBootApplication
public class Application {

  public static void connectMongoDB() {
    MongoClient mongo = new MongoClient("localhost", 27017);
    MongoDatabase dbDriver = mongo.getDatabase("test");
    System.out.println("get Database test....");
  }

  public static void main(String[] args) {
//    connectMongoDB();
//    showAllDocument();
    showAllCollections();
//    SpringApplication.run(Application.class, args);
  }

  private static void showAllCollections() {
    String dbName = "test";
    //    connect db
    MongoClient mongo = new MongoClient("localhost", 27017);
    System.out.println("Connected to database...");
    //    get db
    MongoDatabase dbDriver = mongo.getDatabase(dbName);
    System.out.println("getting database...");
    for (String collectionName :
        dbDriver.listCollectionNames()) {
      System.out.println("collection name: " + collectionName);
    }
  }

  private static void showAllDocument() {
    String dbName = "test";
    String dbCollectionName = "test";
//    connect db
    MongoClient mongo = new MongoClient("localhost", 27017);
    System.out.println("Connected to database...");
//    get db
    MongoDatabase dbDriver = mongo.getDatabase(dbName);
    System.out.println("getting database...");
    //    get collection
    MongoCollection<Document> dbCollection = dbDriver.getCollection(dbCollectionName);
    System.out.println("retrieving collection...");
//    getting iterable object
    FindIterable<Document> itDoc = dbCollection.find();
//    getting iterator
    Iterator it = itDoc.iterator();

//    display docs
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

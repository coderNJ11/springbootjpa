import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;
import java.util.List;

public class MongoQuery {
    public static void main(String[] args) {
        String connectionString = "mongodb://<username>:<password>@<host>:<port>/<databaseName>";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("<databaseName>");
            MongoCollection<Document> collection = database.getCollection("<collectionName>");

            // Transformation mapping: From field in the database to the target field name
            List<Document> transformationMapping = Arrays.asList(
                    new Document("leave_details..manager_name", "manager"),
                    new Document("requester_name", "requester"),
                    new Document("createOn", "createOn"),
                    new Document("leave_details._id", "_id"),
                    new Document("leave_details.first_name", "first_name"),
                    new Document("leave_details.last_name", "last_name"),
                    new Document("leave_details.start_date", "start_date")
            );

            // Build the projection pipeline based on the transformation mapping
            Document projectionFields = new Document();
            for (Document mapping : transformationMapping) {
                for (String sourceField : mapping.keySet()) {
                    String targetField = mapping.getString(sourceField);
                    projectionFields.append(targetField, "$data." + sourceField);
                }
            }

            // MongoDB aggregation pipeline
            List<Document> pipeline = Arrays.asList(
                    new Document("$unwind", "$data.leave_details"), // Unwind leave_details array
                    new Document("$project", projectionFields)     // Include specified fields with renamed keys
            );

            // Execute the query
            collection.aggregate(pipeline).forEach(document -> {
                System.out.println(document.toJson());
            });
        }
    }
}
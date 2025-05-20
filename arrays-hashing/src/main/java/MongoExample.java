import com.clearspring.analytics.util.Lists;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MongoExample {
    public final MongoCollection<Document> trdHistoryCollection;

    public MongoExample(MongoCollection<Document> trdHistoryCollection) {
        this.trdHistoryCollection = trdHistoryCollection;
    }

//    The method getAggDoc is designed to fetch aggregated data from the MongoDB collection trdHistoryCollection
//    based on a set of document IDs. It returns a list of aggregated documents containing specific fields such
//    as maxEventTimeStamp, totalQty, maxCreationDateInUTC, and minCreationDateInUTC.
    public ArrayList<Document> getAggDoc(final Set<String> keys) {
        List<String> values = Lists.newArrayList(keys);

        //Constructs a MongoDB aggregation pipeline. The pipeline consists of three stages: $match, $group, and $project.
        List<Document> pipeline = Arrays.asList(
                //Filters the documents in the collection to only include those whose _id is in the list values.
                new Document()
                        .append("$match", new Document()
                                .append("_id", new Document()
                                        .append("$in", values)
                                )
                        ),
                //Groups the matched documents. Since _id is an empty document (new Document()),
                // all matched documents are considered as one group.
                new Document()
                        .append("$group", new Document()
                                .append("_id", new Document())
                                //Computes aggregate fields:
                                //maxEventTimeStamp: The maximum value of eventTimeStamp field among the matched documents.
                                //totalQty: The sum of the qty field among the matched documents.
                                //maxCreationDateInUTC: The maximum value of creationDateInUTC field among the matched documents.
                                //minCreationDateInUTC: The minimum value of creationDateInUTC field among the matched documents.
                                .append("maxEventTimeStamp", new Document()
                                        .append("$max", "$eventTimeStamp")
                                )
                                .append("totalQty", new Document()
                                        .append("$sum", "$qty")
                                )
                                .append("maxCreationDateInUTC", new Document()
                                        .append("$max", "$creationDateInUTC")
                                ).append("minCreationDateInUTC", new Document()
                                        .append("$min", "$creationDateInUTC")
                                )
                        ),
                //Projects (includes) only the specified fields
                // (maxEventTimeStamp, totalQty, maxCreationDateInUTC, minCreationDateInUTC) in the final output.
                //Excludes the _id field from the output by setting it to 0.
                new Document()
                        .append("$project", new Document()
                                .append("maxEventTimeStamp", "$maxEventTimeStamp")
                                .append("totalQty", "$totalQty")
                                .append("maxCreationDateInUTC", "$maxCreationDateInUTC")
                                .append("minCreationDateInUTC", "$minCreationDateInUTC")
                                .append("_id", 0)
                        )
        );
        //Executes the aggregation pipeline on the trdHistoryCollection and collects the results into a new ArrayList<Document>.
        //The aggregate method returns an iterable of documents, which is then converted into an ArrayList<Document>.
        return trdHistoryCollection.aggregate(pipeline).into(new ArrayList<>());
    }
}

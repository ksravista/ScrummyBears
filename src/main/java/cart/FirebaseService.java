package cart;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {


    public String saveItem(Item item) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("items").document(item.getItemId()+"").set(item);
        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public List<Item> getItemById(long id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference items = dbFirestore.collection("items");


        Query query = items.whereEqualTo("cartID", (int)id);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        ArrayList<Item> list = new ArrayList<>();
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            list.add(document.toObject(Item.class));
        }

        return list;
    }

    public String deleteItem(String id) throws ExecutionException, InterruptedException {


        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("items").document(id).delete();
        return writeResult.get().getUpdateTime().toString();



    }
}

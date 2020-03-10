package cart;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {


    public String saveItem(Item item) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("items").document(item.getCartId()+"").set(item);
        return collectionApiFuture.get().getUpdateTime().toString();

    }
}

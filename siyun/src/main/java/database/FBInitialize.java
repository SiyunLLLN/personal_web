package database;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./personalwebsite-b3a29-firebase-adminsdk-2cbct-af470aabf6.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            		  .setDatabaseUrl("https://personalwebsite-b3a29-default-rtdb.firebaseio.com")
            		  .build();

            		FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
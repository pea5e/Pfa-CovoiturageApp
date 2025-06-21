//package pfe.emsi.covoiturage.voyage.Config;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//
//
//
//@Configuration
//public class FirebaseConfig {
//
//    @Bean
//    public FirebaseApp firebaseApp() throws IOException {
//        FileInputStream serviceAccount =
//            new FileInputStream("src/main/resources/FirebaseSDK.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//            .build();
//
//        return FirebaseApp.initializeApp(options);
//    }
//}
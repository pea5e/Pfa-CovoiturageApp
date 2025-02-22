package pfe.emsi.covoiturage.voyage.Service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class NotificationService {

    public void sendNotification(String token, String title, String body) {
        Message message = Message.builder()
            .setToken(token)
            .setNotification(Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build())
            .build();

        try {
            System.out.println(FirebaseMessaging.getInstance().send(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
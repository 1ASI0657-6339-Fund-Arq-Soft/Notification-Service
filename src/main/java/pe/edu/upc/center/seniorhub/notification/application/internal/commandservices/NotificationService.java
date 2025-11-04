package pe.edu.upc.center.seniorhub.notification.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.notification.domain.model.dto.NotificationDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    // Simulación básica de almacenamiento en memoria (como en el monolito)
    private List<NotificationDTO> notifications = new ArrayList<>();

    public List<NotificationDTO> getAllNotifications() {
        return new ArrayList<>(notifications);
    }

    public List<NotificationDTO> searchNotifications(String status) {
        return notifications.stream()
                .filter(notification -> notification.getStatus().equals(status))
                .toList();
    }

    public List<NotificationDTO> getNotificationsByUserId(String userId) {
        return notifications.stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .toList();
    }

    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        // Asignar un ID simple
        notificationDTO.setId(String.valueOf(notifications.size() + 1));
        notifications.add(notificationDTO);
        return notificationDTO;
    }

    public NotificationDTO markAsRead(String id) {
        NotificationDTO notification = findById(id);
        if (notification != null) {
            notification.setStatus("read");
        }
        return notification;
    }

    public NotificationDTO archiveNotification(String id) {
        NotificationDTO notification = findById(id);
        if (notification != null) {
            notification.setStatus("archived");
        }
        return notification;
    }

    public void deleteNotification(String id) {
        notifications.removeIf(notification -> notification.getId().equals(id));
    }

    private NotificationDTO findById(String id) {
        return notifications.stream()
                .filter(notification -> notification.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
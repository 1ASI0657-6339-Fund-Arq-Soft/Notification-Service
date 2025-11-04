package pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources;

public record CreateNotificationResource(
        String title,
        String content,
        Long userId,
        Long recipientId,
        String type
) {}
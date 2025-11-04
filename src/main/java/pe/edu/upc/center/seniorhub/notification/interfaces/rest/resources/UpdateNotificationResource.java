package pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources;

public record UpdateNotificationResource(
        String title,
        String content,
        String status,
        String type
) {}
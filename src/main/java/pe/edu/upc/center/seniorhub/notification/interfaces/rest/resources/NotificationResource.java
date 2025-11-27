package pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources;

import java.util.Date;

public record NotificationResource(
        Long id,
        String title,
        String content,
        String status,
        Long userId,
        Long recipientId,
        String type,
        Date createdAt
) {}
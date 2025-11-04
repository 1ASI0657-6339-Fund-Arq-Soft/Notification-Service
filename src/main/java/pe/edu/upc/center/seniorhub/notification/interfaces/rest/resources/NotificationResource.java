package pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources;

import java.time.LocalDateTime;

public record NotificationResource(
        Long id,
        String title,
        String content,
        LocalDateTime timestamp,
        String status,
        Long userId,
        Long recipientId,
        String type
) {}
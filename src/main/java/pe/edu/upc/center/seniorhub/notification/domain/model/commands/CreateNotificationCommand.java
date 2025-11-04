package pe.edu.upc.center.seniorhub.notification.domain.model.commands;

public record CreateNotificationCommand(
        String title,
        String content,
        Long userId,
        Long recipientId,
        String type
) {}
package pe.edu.upc.center.seniorhub.notification.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.notification.domain.model.aggregates.Notification;
import pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity) {
        return new NotificationResource(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getStatus(),
                entity.getUserId(),
                entity.getRecipientId(),
                entity.getType(),
                entity.getCreatedAt()
        );
    }
}
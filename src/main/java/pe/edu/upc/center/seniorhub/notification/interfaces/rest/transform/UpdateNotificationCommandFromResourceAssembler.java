package pe.edu.upc.center.seniorhub.notification.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.notification.domain.model.commands.UpdateNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources.UpdateNotificationResource;

public class UpdateNotificationCommandFromResourceAssembler {
    public static UpdateNotificationCommand toCommandFromResource(Long notificationId, UpdateNotificationResource resource) {
        return new UpdateNotificationCommand(
                notificationId,
                resource.title(),
                resource.content(),
                resource.status(),
                resource.type()
        );
    }
}
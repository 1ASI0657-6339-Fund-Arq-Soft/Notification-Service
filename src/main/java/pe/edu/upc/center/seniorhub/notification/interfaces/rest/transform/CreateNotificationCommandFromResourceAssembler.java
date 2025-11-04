package pe.edu.upc.center.seniorhub.notification.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.notification.domain.model.commands.CreateNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(
                resource.title(),
                resource.content(),
                resource.userId(),
                resource.recipientId(),
                resource.type()
        );
    }
}
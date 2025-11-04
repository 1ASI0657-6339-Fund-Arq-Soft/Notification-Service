package pe.edu.upc.center.seniorhub.notification.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.notification.domain.model.aggregates.Notification;
import pe.edu.upc.center.seniorhub.notification.domain.model.commands.CreateNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.domain.model.commands.DeleteNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.domain.model.commands.UpdateNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.domain.services.NotificationCommandService;
import pe.edu.upc.center.seniorhub.notification.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {
    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Long handle(CreateNotificationCommand command) {
        Notification notification = new Notification(command);
        try {
            this.notificationRepository.save(notification);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving notification: " + e.getMessage());
        }
        return notification.getId();
    }

    @Override
    public Optional<Notification> handle(UpdateNotificationCommand command) {
        var notificationId = command.notificationId();

        if (!this.notificationRepository.existsById(notificationId)) {
            throw new IllegalArgumentException("Notification " + command.notificationId() + " does not exist");
        }

        var notificationToUpdate = this.notificationRepository.findById(notificationId).get();
        notificationToUpdate.updateInformation(
                command.title(),
                command.content(),
                command.status(),
                command.type()
        );

        try {
            var updatedNotification = this.notificationRepository.save(notificationToUpdate);
            return Optional.of(updatedNotification);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating notification: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        if (!this.notificationRepository.existsById(command.notificationId())) {
            throw new IllegalArgumentException("Notification with id " + command.notificationId() + " does not exist");
        }

        try {
            this.notificationRepository.deleteById(command.notificationId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting notification: " + e.getMessage());
        }
    }
}
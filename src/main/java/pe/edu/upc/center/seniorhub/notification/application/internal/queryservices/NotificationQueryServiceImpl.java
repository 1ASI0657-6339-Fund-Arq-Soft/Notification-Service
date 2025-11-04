package pe.edu.upc.center.seniorhub.notification.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.notification.domain.model.aggregates.Notification;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetAllNotificationsQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationByIdQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationsByUserIdQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationsByRecipientIdQuery;
import pe.edu.upc.center.seniorhub.notification.domain.services.NotificationQueryService;
import pe.edu.upc.center.seniorhub.notification.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsQuery query) {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.notificationId());
    }

    @Override
    public List<Notification> handle(GetNotificationsByUserIdQuery query) {
        return notificationRepository.findByUserId(query.userId());
    }

    @Override
    public List<Notification> handle(GetNotificationsByRecipientIdQuery query) {
        return notificationRepository.findByRecipientId(query.recipientId());
    }
}
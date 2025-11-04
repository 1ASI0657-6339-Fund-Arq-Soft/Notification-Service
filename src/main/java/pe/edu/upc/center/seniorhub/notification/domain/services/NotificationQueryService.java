package pe.edu.upc.center.seniorhub.notification.domain.services;

import pe.edu.upc.center.seniorhub.notification.domain.model.aggregates.Notification;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetAllNotificationsQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationByIdQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationsByUserIdQuery;
import pe.edu.upc.center.seniorhub.notification.domain.model.queries.GetNotificationsByRecipientIdQuery;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService {
    List<Notification> handle(GetAllNotificationsQuery query);
    Optional<Notification> handle(GetNotificationByIdQuery query);
    List<Notification> handle(GetNotificationsByUserIdQuery query);
    List<Notification> handle(GetNotificationsByRecipientIdQuery query);
}
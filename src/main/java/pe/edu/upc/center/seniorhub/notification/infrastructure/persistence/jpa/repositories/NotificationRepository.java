package pe.edu.upc.center.seniorhub.notification.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.seniorhub.notification.domain.model.aggregates.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    List<Notification> findByUserId(Long userId);
    
    List<Notification> findByRecipientId(Long recipientId);
    
    List<Notification> findByStatus(String status);
    
    List<Notification> findByType(String type);
    
    List<Notification> findByUserIdAndStatus(Long userId, String status);
    
    List<Notification> findByRecipientIdAndStatus(Long recipientId, String status);
}
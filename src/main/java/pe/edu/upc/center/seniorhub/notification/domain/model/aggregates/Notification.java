package pe.edu.upc.center.seniorhub.notification.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.edu.upc.center.seniorhub.notification.domain.model.commands.CreateNotificationCommand;
import pe.edu.upc.center.seniorhub.notification.shared.domain.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    public Notification() {
    }

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime timestamp;

    @NotNull
    @Column(nullable = false)
    private String status;

    @NotNull
    @Column(nullable = false)
    private Long userId;

    @NotNull
    @Column(nullable = false)
    private Long recipientId;

    @NotNull
    @Column(nullable = false)
    private String type;

    // Constructor completo
    public Notification(String title, String content, LocalDateTime timestamp, String status, 
                       Long userId, Long recipientId, String type) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
        this.userId = userId;
        this.recipientId = recipientId;
        this.type = type;
    }

    // Constructor desde CreateNotificationCommand
    public Notification(CreateNotificationCommand command) {
        this(
                command.title(),
                command.content(),
                LocalDateTime.now(),
                "unread",
                command.userId(),
                command.recipientId(),
                command.type()
        );
    }

    // Método para actualizar información básica
    public void updateInformation(String title, String content, String status, String type) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.type = type;
    }

    // Método para marcar como leída
    public void markAsRead() {
        this.status = "read";
    }

    // Método para marcar como no leída
    public void markAsUnread() {
        this.status = "unread";
    }

    // Getters manuales
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public String getType() {
        return type;
    }
}
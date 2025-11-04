package pe.edu.upc.center.seniorhub.notification.domain.model.dto;

public class NotificationDTO {
    private String id;
    private String message;
    private String userId;
    private String status;
    private String createdAt;

    public NotificationDTO() {
    }

    public NotificationDTO(String id, String message, String userId, String status, String createdAt) {
        this.id = id;
        this.message = message;
        this.userId = userId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
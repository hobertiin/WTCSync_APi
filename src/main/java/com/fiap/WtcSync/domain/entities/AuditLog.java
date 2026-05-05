package com.fiap.WtcSync.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "audit_logs")
public class AuditLog {

    @Id
    private String id;

    private String action;       // ex: "CREATE_CLIENT", "CREATE_SEGMENT"
    private String entity;       // ex: "Client", "Segment"
    private String entityId;     // id do objeto afetado
    private String performedBy;  // email do usuário que fez a ação
    private LocalDateTime performedAt;
    private String details;      // info extra se necessário

    public AuditLog() {}

    public AuditLog(String action, String entity, String entityId, String performedBy, String details) {
        this.action = action;
        this.entity = entity;
        this.entityId = entityId;
        this.performedBy = performedBy;
        this.performedAt = LocalDateTime.now();
        this.details = details;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getEntity() { return entity; }
    public void setEntity(String entity) { this.entity = entity; }
    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }
    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }
    public LocalDateTime getPerformedAt() { return performedAt; }
    public void setPerformedAt(LocalDateTime performedAt) { this.performedAt = performedAt; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
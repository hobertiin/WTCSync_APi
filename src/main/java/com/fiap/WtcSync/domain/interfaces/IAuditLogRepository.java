package com.fiap.WtcSync.domain.interfaces;

import com.fiap.WtcSync.domain.entities.AuditLog;

import java.util.List;

public interface IAuditLogRepository {

    AuditLog save(AuditLog auditLog);
    List<AuditLog> findAll();
    List<AuditLog> findByEntity(String entity);
    List<AuditLog> findByPerformedBy(String performedBy);
}
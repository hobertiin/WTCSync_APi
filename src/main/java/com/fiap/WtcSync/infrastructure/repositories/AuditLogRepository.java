package com.fiap.WtcSync.infrastructure.repositories;

import com.fiap.WtcSync.domain.entities.AuditLog;
import com.fiap.WtcSync.domain.interfaces.IAuditLogRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditLogRepository implements IAuditLogRepository {

    private final MongoTemplate mongoTemplate;

    public AuditLogRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public AuditLog save(AuditLog auditLog) {
        return mongoTemplate.save(auditLog);
    }

    @Override
    public List<AuditLog> findAll() {
        return mongoTemplate.findAll(AuditLog.class);
    }

    @Override
    public List<AuditLog> findByEntity(String entity) {
        Query query = new Query(Criteria.where("entity").is(entity));
        return mongoTemplate.find(query, AuditLog.class);
    }

    @Override
    public List<AuditLog> findByPerformedBy(String performedBy) {
        Query query = new Query(Criteria.where("performedBy").is(performedBy));
        return mongoTemplate.find(query, AuditLog.class);
    }
}
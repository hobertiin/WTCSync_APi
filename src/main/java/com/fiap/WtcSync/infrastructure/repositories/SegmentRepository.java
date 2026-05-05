package com.fiap.WtcSync.infrastructure.repositories;

import com.fiap.WtcSync.domain.entities.Segment;
import com.fiap.WtcSync.domain.interfaces.ISegmentRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SegmentRepository implements ISegmentRepository {

    private final MongoTemplate mongoTemplate;

    public SegmentRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Segment> findAll() {
        return mongoTemplate.findAll(Segment.class);
    }

    @Override
    public Optional<Segment> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Segment.class));
    }

    @Override
    public Segment save(Segment segment) {
        return mongoTemplate.save(segment);
    }
}
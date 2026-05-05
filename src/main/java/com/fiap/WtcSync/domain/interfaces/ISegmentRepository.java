package com.fiap.WtcSync.domain.interfaces;

import com.fiap.WtcSync.domain.entities.Segment;

import java.util.List;
import java.util.Optional;

public interface ISegmentRepository {

    List<Segment> findAll();
    Optional<Segment> findById(String id);
    Segment save(Segment segment);
}

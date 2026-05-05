package com.fiap.WtcSync.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Resposta com dados do segmento")
public record SegmentResponseDTO(
    String id,
    String name,
    String description,
    List<String> tags,
    String status,
    Integer minScore,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
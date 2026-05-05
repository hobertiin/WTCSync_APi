package com.fiap.WtcSync.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Payload para criação de segmento")
public record SegmentRequestDTO(

    @Schema(description = "Nome do segmento", example = "VIPs", requiredMode = Schema.RequiredMode.REQUIRED)
    String name,

    @Schema(description = "Descrição do segmento", example = "Clientes com score acima de 80")
    String description,

    @Schema(description = "Tags do segmento", example = "[\"vip\", \"premium\"]")
    List<String> tags,

    @Schema(description = "Status do segmento", example = "active")
    String status,

    @Schema(description = "Score mínimo dos clientes", example = "80")
    Integer minScore
) {}
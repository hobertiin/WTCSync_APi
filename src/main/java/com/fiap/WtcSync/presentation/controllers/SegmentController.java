package com.fiap.WtcSync.presentation.controllers;

import com.fiap.WtcSync.application.dtos.ClientResponseDTO;
import com.fiap.WtcSync.application.dtos.SegmentRequestDTO;
import com.fiap.WtcSync.application.dtos.SegmentResponseDTO;
import com.fiap.WtcSync.application.services.SegmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/segments")
@Tag(name = "Segments", description = "Gerenciamento de segmentos")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping
    @Operation(summary = "Lista segmentos", description = "Lista todos os segmentos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public ResponseEntity<List<SegmentResponseDTO>> listSegments() {
        return ResponseEntity.ok(segmentService.listSegments());
    }

    @PostMapping
    @Operation(summary = "Cria segmento", description = "Cria um novo segmento no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Segmento criado com sucesso")
    })
    public ResponseEntity<SegmentResponseDTO> createSegment(@RequestBody SegmentRequestDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String performedBy = auth != null ? auth.getName() : "anonymous";
        return ResponseEntity.status(201).body(segmentService.createSegment(dto, performedBy));
    }

    @GetMapping("/{id}/clients")
    @Operation(summary = "Lista clientes do segmento", description = "Retorna todos os clientes de um segmento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public ResponseEntity<List<ClientResponseDTO>> getClientsBySegment(@PathVariable String id) {
        return ResponseEntity.ok(segmentService.getClientsBySegment(id));
    }
}
package com.fiap.WtcSync.presentation.controllers;

import com.fiap.WtcSync.application.services.AuditLogService;
import com.fiap.WtcSync.domain.entities.AuditLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
@Tag(name = "Audit", description = "Logs de auditoria do sistema")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os logs")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Logs retornados com sucesso")
    })
    public ResponseEntity<List<AuditLog>> listAll() {
        return ResponseEntity.ok(auditLogService.listAll());
    }

    @GetMapping("/entity/{entity}")
    @Operation(summary = "Lista logs por entidade", description = "Ex: Client, Segment")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Logs retornados com sucesso")
    })
    public ResponseEntity<List<AuditLog>> listByEntity(@PathVariable String entity) {
        return ResponseEntity.ok(auditLogService.listByEntity(entity));
    }

    @GetMapping("/user/{email}")
    @Operation(summary = "Lista logs por usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Logs retornados com sucesso")
    })
    public ResponseEntity<List<AuditLog>> listByUser(@PathVariable String email) {
        return ResponseEntity.ok(auditLogService.listByUser(email));
    }
}
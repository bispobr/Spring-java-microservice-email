package com.microservice.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID usuarioId, String emailRemetente, String assunto, String mensagem) {
}

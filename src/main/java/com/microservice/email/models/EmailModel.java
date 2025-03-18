package com.microservice.email.models;

import com.microservice.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "EMAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    private UUID usuarioId;
    private String emailRemetente;
    private String emailDestinatario;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    private LocalDateTime dataEnvioEmail;
    private StatusEmail statusEmail;
}

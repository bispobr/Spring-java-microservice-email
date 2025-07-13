package com.microservice.email.services;

import com.microservice.email.enums.StatusEmail;
import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailDestinatario;

    @Transactional
    public EmailModel enviarEmail(EmailModel emailModel) {
        try{
            log.info("tratando email");
            emailModel.setDataEnvioEmail(LocalDateTime.now());
            emailModel.setEmailDestinatario(emailDestinatario);

            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setTo(emailModel.getEmailRemetente());
            mensagem.setSubject(emailModel.getAssunto());
            mensagem.setText(emailModel.getMensagem());
            javaMailSender.send(mensagem);

            emailModel.setStatusEmail(StatusEmail.enviado);
            log.info("Email enviada");
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.erro);
            log.error("Erro ao enviar email");
        } finally {
            log.info("Email salvo na base de dados");
            return emailRepository.save(emailModel);

        }
    }
}

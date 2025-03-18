package com.microservice.email.services;

import com.microservice.email.enums.StatusEmail;
import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
            emailModel.setDataEnvioEmail(LocalDateTime.now());
            emailModel.setEmailDestinatario(emailDestinatario);

            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setTo(emailModel.getEmailRemetente());
            mensagem.setSubject(emailModel.getAssunto());
            mensagem.setText(emailModel.getMensagem());
            javaMailSender.send(mensagem);

            emailModel.setStatusEmail(StatusEmail.enviado);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.erro);
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}

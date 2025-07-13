package com.microservice.email.consumers;

import com.microservice.email.dtos.EmailRecordDto;
import com.microservice.email.models.EmailModel;
import com.microservice.email.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void escutaFilaEmail(@Payload EmailRecordDto emailRecordDto) {
        log.info("Email chegando");
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        emailService.enviarEmail(emailModel);
    }
}

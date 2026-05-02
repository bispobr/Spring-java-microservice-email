package com.microservice.email.services;


import com.microservice.email.enums.StatusEmail;
import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    public String emailDestinatario = "sistema@email.com";


    @Autowired
    @InjectMocks
    private EmailService emailService;

    private EmailModel emailModel;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
       emailService = new EmailService();
       emailService.emailRepository = emailRepository;
       emailService.javaMailSender = javaMailSender;


        emailModel = new EmailModel();
        emailModel.setEmailRemetente("destinatario@teste.com");
        emailModel.setEmailDestinatario(emailDestinatario);
        emailModel.setAssunto("Teste");
        emailModel.setMensagem("Mensagem de teste");

    }

    @Test
    void deveEnviarEmailComSucesso() {

        when(emailRepository.save(any(EmailModel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        EmailModel resultado = emailService.enviarEmail(emailModel);

        assertEquals(StatusEmail.enviado, resultado.getStatusEmail());
        assertNotNull(resultado.getDataEnvioEmail());


        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
        verify(emailRepository, times(1)).save(any(EmailModel.class));
    }




}
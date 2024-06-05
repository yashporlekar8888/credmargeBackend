package com.credmarg.credmarg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.credmarg.credmarg.model.Email;
import com.credmarg.credmarg.repository.EmailRepository;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);

            Email email = new Email();
            email.setContent(body);
            emailRepository.save(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Email> getAllSentEmails() {
        return emailRepository.findAll();
    }
}

package com.example.spring_schedule.service;

import org.springframework.web.multipart.MultipartFile;

public interface SendEmail {
    String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);

    String sendMailWithoutFile(String to, String subject, String body);
}

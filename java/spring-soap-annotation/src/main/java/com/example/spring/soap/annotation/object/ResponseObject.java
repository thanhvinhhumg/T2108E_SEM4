package com.example.spring.soap.annotation.object;

import lombok.Data;

@Data
public class ResponseObject {
    private Integer errorCode;
    private String message;
}

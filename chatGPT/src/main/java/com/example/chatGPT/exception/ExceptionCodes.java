package com.example.chatGPT.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionCodes {
    EMPLOYEE_NOT_FOUND("EXCPTION-001");

    public final String code;
}

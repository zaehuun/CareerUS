package com.project.backend.common.exceptions.dto;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private String code;

    public ErrorResponse(ErrorCode code){
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    public static ErrorResponse of(ErrorCode code){
        return new ErrorResponse(code);
    }

}

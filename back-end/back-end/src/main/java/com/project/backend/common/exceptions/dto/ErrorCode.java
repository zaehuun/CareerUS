package com.project.backend.common.exceptions.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATED_ID(400, "C_001", "이미 존재하는 아이디입니다."),
    INVALID_INPUT(400, "C_002", "빈 칸을 모두 입력하세요."),
    BAD_LOGIN(400, "C_003", "로그인 정보를 확인하세요.");


    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

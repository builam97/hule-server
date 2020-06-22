package com.example.demo.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class HuleResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static int FAILED = 1;

    public final static int SUCCESS = 0;

    private Integer status;

    private Object result;

    private String errorCode;

    private String message;

    public HuleResponse() {

    }

    public HuleResponse(Integer status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
    
    public HuleResponse(Integer status, Object result) {
        this.status = status;
        this.result = result;
    }
}

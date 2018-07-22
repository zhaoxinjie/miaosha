package com.example.miaosha.exception;

import com.example.miaosha.result.CodeMessage;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 899648741060478206L;

    private CodeMessage cm;

    public GlobalException(CodeMessage cm){
        this.cm = cm;
    }
}

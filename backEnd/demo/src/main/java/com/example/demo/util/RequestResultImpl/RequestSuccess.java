package com.example.demo.util.RequestResultImpl;

import com.example.demo.util.RequestResult;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * RequestSuccess:
 *
 * @author XvYanPeng
 * @date 2019/8/12 11:29
 */
@Data
public class RequestSuccess implements RequestResult {
    private int code=0;
    private String message;
    private Object result;

    public RequestSuccess(String message, Object result) {
        this.message = message;
        this.result = result;
    }
}

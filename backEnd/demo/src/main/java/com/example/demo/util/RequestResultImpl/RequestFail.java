package com.example.demo.util.RequestResultImpl;

import com.example.demo.util.RequestResult;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * RequestFail:
 *
 * @author XvYanPeng
 * @date 2019/8/12 11:43
 */
@Data
public class RequestFail implements RequestResult {
    private int code=1;
    private String message;

    public RequestFail(String message) {
        this.message = message;
    }
}

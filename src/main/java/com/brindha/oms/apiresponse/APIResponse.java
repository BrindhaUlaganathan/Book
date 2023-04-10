package com.brindha.oms.apiresponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class APIResponse {

    private Integer status;
    private Object data;
    private Object error;

    public APIResponse() {
        this.status = HttpStatus.OK.value(); //200;
        this.data = data;
        this.error = error;
    }
}

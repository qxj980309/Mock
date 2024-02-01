package com.example.mock.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> implements Serializable {
    private static final long serialVersionUID =1L;

    private String code = "0";

    private String message = "success";

    private T data;

    public RestResponse() {
    }

    public RestResponse(T data) {
        this.data=data;
    }

    public static <T> RestResponse<T> empty(){
        return new RestResponse();
    }

    public static <T> RestResponse<T> success(T data){
        return new RestResponse(data);
    }

    public static <T> RestResponse<T> success(String message){
        RestResponse<T> restResponse = new RestResponse();
        restResponse.setMessage(message);
        return restResponse;
    }

    public static <T> RestResponse<T> success(T data,String message){
        RestResponse<T> restResponse = new RestResponse(data);
        restResponse.setMessage(message);
        return restResponse;
    }

    public static <T> RestResponse<T> fail(String message){
        return fail(message);
    }

    public static <T> RestResponse<T> fail(String code,String message){
        RestResponse<T> restResponse = new RestResponse();
        restResponse.setCode(code);
        restResponse.setMessage(message);
        return restResponse;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestResponse)) return false;
        RestResponse<?> that = (RestResponse<?>) o;
        return getCode().equals(that.getCode()) &&
                getMessage().equals(that.getMessage()) &&
                getData().equals(that.getData());
    }

    protected boolean canEqual(Object other){
        return other instanceof RestResponse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "RestResponse{ code=" + this.getCode() + ", message=" +this.getMessage() + ", data=" + this.getData() + "}";
    }
}

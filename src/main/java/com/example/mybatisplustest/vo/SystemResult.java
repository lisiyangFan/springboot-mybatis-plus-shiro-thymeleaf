package com.example.mybatisplustest.vo;

public class SystemResult {
    private String message;
    private Integer status;
    private Object data;

    private SystemResult() {
    }
    public SystemResult(String message, Integer status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static SystemResult isOk(){
      return  new SystemResult("success",200,null);
    }
    public static SystemResult isOk(Object data){
        return  new SystemResult("success",200,data);
    }

    public static SystemResult result(String message,Integer status){
        return  new SystemResult(message,status,null);
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

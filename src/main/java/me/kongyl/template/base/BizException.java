package me.kongyl.template.base;

public class BizException extends Exception {

    private static final long serialVersionUID = 1354116741259232355L;
    
    private int code;
    
    private String message;
    
    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public BizException(ResMessage resMessage) {
        this.code = resMessage.getCode();
        this.message = resMessage.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

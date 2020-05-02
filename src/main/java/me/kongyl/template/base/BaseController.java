package me.kongyl.template.base;

public class BaseController {

    protected <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setMessage(ResMessage.SUCCESS.getMessage());
        return result;
    }
    
    protected <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setMessage(ResMessage.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }
    
    protected <T> Result<T> error(ResMessage resMessage) {
        Result<T> result = new Result<T>();
        result.setCode(resMessage.getCode());
        result.setMessage(resMessage.getMessage());
        return result;
    }
    
    protected <T> Result<T> error(BizException exception) {
        Result<T> result = new Result<T>();
        result.setCode(exception.getCode());
        result.setMessage(exception.getMessage());
        return result;
    }
    
}

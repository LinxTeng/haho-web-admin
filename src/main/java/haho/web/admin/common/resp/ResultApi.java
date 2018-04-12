package haho.web.admin.common.resp;

import java.io.Serializable;

public class ResultApi<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 成功返回码
     */
    public static final String RESULT_CODE_SUCCESS = "0";

    /**
     * 未知错误返回码
     */
    public static final String RESULT_CODE_FAIL = "-1";

    /**
     * <pre>
     * 返回码 
     * 0：成功（默认值） 
     * 其他：失败
     * </pre>
     */
    private String code = RESULT_CODE_SUCCESS;

    /**
     * 响应消息内容，可存放错误提示消息或成功消息
     */
    private String message;

    /**
     * 响应对象
     */
    private T entry;


    private ResultApi() {}

    /**
     * 构建一个新的实例
     * 
     */
    public static <T> ResultApi<T> build() {
        return new ResultApi<>();
    }

    public static <T> ResultApi<T> build(Class<T> clazz) {
        return new ResultApi<T>();
    }

    /**
     * 判断返回结果中响应码是否成功
     * 
     */
    public boolean isSuccess() {
        return RESULT_CODE_SUCCESS.equals(code);
    }

    /**
     * 返回错误信息，标记响应码为-1
     */
    public ResultApi<T> error(String message) {
        return error(RESULT_CODE_FAIL, message);
    }

    /**
     * 返回错误信息，标记响应码为具体的错误码
     * 
     */
    public ResultApi<T> error(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
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

    public T getEntry() {
        return entry;
    }

    public void setEntry(T entry) {
        this.entry = entry;
    }
}

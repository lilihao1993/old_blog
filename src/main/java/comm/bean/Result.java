package comm.bean;

/**
 * 结果对象封装
 * Created by yushunwei on 2016/9/28.
 */
public class Result<T> {

    /**
     * 结果数据
     */
    private T data;

    /**
     * 结果标识
     */
    private boolean flag;

    /**
     * 业务编码
     */
    private int code;

    /**
     *
     */
    private String error;

    public Result(){

    }

    public Result(T data){
        this.data = data;
        this.flag = true;
    }

    public Result(int code, String error){
        this.flag = false;
        this.code = code;
        this.error = error;
    }

    public boolean success(){
        return this.flag == true;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

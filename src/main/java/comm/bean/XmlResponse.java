package comm.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Xml格式响应
 * Created by yushunwei on 2016/10/17.
 */
@XStreamAlias("RESULT")
public class XmlResponse<T> {

    /**
     * 错误编码
     */
    @XStreamAlias("CODE")
    protected String code;

    /**
     * 错误信息
     */
    @XStreamAlias("MSG")
    protected String msg;

    /**
     * 数据
     */
    @XStreamAlias("DATA")
    protected T data;

    public XmlResponse(){

    }

    /**
     * 自定义构造函数
     * @param data 业务数据
     */
    public XmlResponse(T data){
        this.data = data;
        this.msg = "操作成功";
    }

    /**
     * 自定义构造函数
     * @param code 错误编码
     * @param msg 错误信息
     */
    public XmlResponse(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

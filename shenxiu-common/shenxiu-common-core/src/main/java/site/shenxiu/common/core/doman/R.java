package site.shenxiu.common.core.doman;

import lombok.Data;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.constant.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author Shenxiu
 * @date 2022/10/31 10:08
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = HttpStatus.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = HttpStatus.ERROR;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private T data;

    /**
     * 成功响应
     *
     * @return 响应信息
     */
    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, "操作成功");
    }

    /**
     * 成功响应
     *
     * @param data 数据对象
     * @return 响应信息
     */
    public static <T> R<T> ok(T data) {
        return restResult(data, SUCCESS, "操作成功");
    }

    /**
     * 成功响应
     *
     * @param msg 消息内容
     * @return 响应信息
     */
    public static <T> R<T> ok(String msg) {
        return restResult(null, SUCCESS, msg);
    }

    /**
     * 成功响应
     *
     * @param msg  消息内容
     * @param data 数据对象
     * @return 响应信息
     */
    public static <T> R<T> ok(String msg, T data) {
        return restResult(data, SUCCESS, msg);
    }

    /**
     * 失败响应
     *
     * @return 响应信息
     */
    public static <T> R<T> fail() {
        return restResult(null, FAIL, "操作失败");
    }

    /**
     * 失败响应
     *
     * @param msg 消息内容
     * @return 响应信息
     */
    public static <T> R<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }


    /**
     * 失败响应
     *
     * @param data 数据对象
     * @return 响应信息
     */
    public static <T> R<T> fail(T data) {
        return restResult(data, FAIL, "操作失败");
    }

    /**
     * 失败响应
     *
     * @param msg  消息内容
     * @param data 数据对象
     * @return 响应信息
     */
    public static <T> R<T> fail(String msg, T data) {
        return restResult(data, FAIL, msg);
    }

    /**
     * 失败响应
     *
     * @param code 消息状态码
     * @param msg  消息内容
     * @return 响应信息
     */
    public static <T> R<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    public static <T> R<T> toAjax(int rows) {
        return rows > 0 ? R.ok() : R.fail();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    public static <T> R<T> toAjax(boolean result) {
        return result ? R.ok() : R.fail();
    }

}

package site.shenxiu.common.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.constant.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author ShenXiu
 * @version 2022/10/31 10:08
 */
@Data
@NoArgsConstructor
public class ResEntity<T> implements Serializable {

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
     * @param <T> 泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> success() {
        return restResult(null, SUCCESS, "操作成功");
    }

    /**
     * 成功响应
     *
     * @param data 数据对象
     * @param <T>  泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> success(T data) {
        return restResult(data, SUCCESS, "操作成功");
    }

    /**
     * 成功响应
     *
     * @param msg 消息内容
     * @param <T> 泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> success(String msg) {
        return restResult(null, SUCCESS, msg);
    }

    /**
     * 成功响应
     *
     * @param msg  消息内容
     * @param data 数据对象
     * @param <T>  泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> success(String msg, T data) {
        return restResult(data, SUCCESS, msg);
    }

    /**
     * 失败响应
     *
     * @param <T> 泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> fail() {
        return restResult(null, FAIL, "操作失败");
    }

    /**
     * 失败响应
     *
     * @param msg 消息内容
     * @param <T> 泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }


    /**
     * 失败响应
     *
     * @param data 数据对象
     * @param <T>  泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> fail(T data) {
        return restResult(data, FAIL, "操作失败");
    }

    /**
     * 失败响应
     *
     * @param msg  消息内容
     * @param data 数据对象
     * @param <T>  泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> fail(String msg, T data) {
        return restResult(data, FAIL, msg);
    }

    /**
     * 失败响应
     *
     * @param code 消息状态码
     * @param msg  消息内容
     * @param <T>  泛型参数
     * @return 响应信息
     */
    public static <T> ResEntity<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    /**
     * rest结果
     *
     * @param data 数据对象
     * @param code 消息状态码
     * @param msg  消息内容
     * @param <T>  泛型参数
     * @return R
     */
    private static <T> ResEntity<T> restResult(T data, int code, String msg) {
        ResEntity<T> resEntity = new ResEntity<>();
        resEntity.setCode(code);
        resEntity.setData(data);
        resEntity.setMsg(msg);
        return resEntity;
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @param <T>  泛型参数
     * @return 操作结果
     */
    public static <T> ResEntity<T> toAjax(int rows) {
        return rows > 0 ? ResEntity.success() : ResEntity.fail();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @param <T>    泛型参数
     * @return 操作结果
     */
    public static <T> ResEntity<T> toAjax(boolean result) {
        return result ? ResEntity.success() : ResEntity.fail();
    }

}

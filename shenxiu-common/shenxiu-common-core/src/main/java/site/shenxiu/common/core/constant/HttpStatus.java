package site.shenxiu.common.core.constant;

/**
 * 返回状态码
 *
 * @author shenxiu
 * @version 2022/10/31 9:57
 * @see java.net.HttpURLConnection
 */
public interface HttpStatus {
    /**
     * 操作成功
     */
    int SUCCESS = 200;
    /**
     * 对象创建成功
     */
    int CREATED = 201;
    /**
     * 请求已经被接受
     */
    int ACCEPTED = 202;
    /**
     * 操作已经执行成功，但是没有返回数据
     */
    int NOT_AUTHORITATIVE = 203;
    /**
     * 无内容
     */
    int NO_CONTENT = 204;
    /**
     * 重置内容
     */
    int RESET = 205;
    /**
     * 局部内容
     */
    int PARTIAL = 206;
    /**
     * 多重选择
     */
    int MULT_CHOICE = 300;
    /**
     * 资源已被移除 响应新的资源
     */
    int MOVED_PERM = 301;
    /**
     *
     */
    int MOVED_TEMP = 302;
    /**
     * 重定向
     */
    int SEE_OTHER = 303;
    /**
     * 资源没有被修改
     */
    int NOT_MODIFIED = 304;
    int USE_PROXY = 305;
    int TEMP_REDIRECT = 307;
    int PERMANENT_REDIRECT = 308;
    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    int BAD_REQUEST = 400;
    /**
     * 未授权
     */
    int UNAUTHORIZED = 401;
    int PAYMENT_REQUIRED = 402;
    /**
     * 访问受限，授权过期
     */
    int FORBIDDEN = 403;
    /**
     * 资源，服务未找到
     */
    int NOT_FOUND = 404;
    /**
     * 不允许的http方法
     */
    int BAD_METHOD = 405;
    int NOT_ACCEPTABLE = 406;
    int PROXY_AUTH = 407;
    int CLIENT_TIMEOUT = 408;
    /**
     * 资源冲突，或者资源被锁
     */
    int CONFLICT = 409;
    int GONE = 410;
    int LENGTH_REQUIRED = 411;
    int PRECON_FAILED = 412;
    int ENTITY_TOO_LARGE = 413;
    int REQ_TOO_LONG = 414;
    /**
     * 不支持的数据，媒体类型
     */
    int UNSUPPORTED_TYPE = 415;
    /**
     * 系统内部错误
     */
    int ERROR = 500;
    /**
     * 接口未实现
     */
    int NOT_IMPLEMENTED = 501;
    int BAD_GATEWAY = 502;
    int UNAVAILABLE = 503;
    int GATEWAY_TIMEOUT = 504;
    int VERSION = 505;

    /**
     * 内部调用错误 默认10000
     */
    int SYSTEM_INNER_ERROR = 10000;
}

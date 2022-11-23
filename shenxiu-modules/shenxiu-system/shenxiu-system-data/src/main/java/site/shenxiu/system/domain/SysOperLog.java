package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.web.domain.BaseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作日志记录表 oper_log
 *
 * @author ShenXiu
 * @version 2022/11/16 16:41
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("sys_oper_log")
public class SysOperLog extends BaseEntity {

    /**
     * 日志主键
     */
    @TableId(value = "oper_id")
    private Long operId;

    /**
     * 操作模块
     */
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType;

    /**
     * 业务类型数组
     */
    @TableField(exist = false)
    private Integer[] businessTypes;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer operatorType;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 请求url
     */
    private String operUrl;

    /**
     * 操作地址
     */
    private String operIp;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 操作时间
     */
    private Date operTime;

    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();

}
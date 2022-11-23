package site.shenxiu.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.web.domain.BaseEntity;

/**
 * 当前在线会话
 *
 * @author ShenXiu
 * @version 2022/11/16 16:40
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SysUserOnline extends BaseEntity {

    /**
     * 会话编号
     */
    private String tokenId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 登录时间
     */
    private Long loginTime;

}

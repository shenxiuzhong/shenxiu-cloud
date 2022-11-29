package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 系统访问记录表 sys_login_info
 *
 * @author ShenXiu
 * @version 2022/11/16 16:22
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("sys_login_info")
public class SysLoginInfo extends BaseEntity {

    /**
     * ID
     */
    @TableId(value = "info_id")
    private Long infoId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 状态 0成功 1失败
     */
    private String status;

    /**
     * 地址
     */
    private String ipaddr;

    /**
     * 描述
     */
    private String msg;

    /**
     * 访问时间
     */
    private Date accessTime;

}

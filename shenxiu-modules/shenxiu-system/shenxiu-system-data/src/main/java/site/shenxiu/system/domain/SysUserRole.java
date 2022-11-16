package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.web.domain.BaseEntity;

/**
 * 用户和角色关联 sys_user_role
 *
 * @author ShenXiu
 * @version 2022/11/16 16:44
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}

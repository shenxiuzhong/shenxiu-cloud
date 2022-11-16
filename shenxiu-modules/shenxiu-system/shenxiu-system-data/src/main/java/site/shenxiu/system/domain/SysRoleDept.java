package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.web.domain.BaseEntity;

/**
 * 角色和部门关联 sys_role_dept
 *
 * @author ShenXiu
 * @version 2022/11/16 16:44
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("sys_role_dept")
public class SysRoleDept extends BaseEntity {

    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    private Long roleId;

    /**
     * 部门ID
     */
    private Long deptId;

}

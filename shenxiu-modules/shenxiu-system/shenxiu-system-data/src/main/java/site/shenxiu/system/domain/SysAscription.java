package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.domain.BaseEntity;

/**
 * 归属表，人员归属
 *
 * @author shenxiu
 * @version 2022/11/30 13:14
 */
@TableName(value ="sys_ascription")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SysAscription extends BaseEntity {
    /**
     * 主键
     */
    @TableId(value = "ascription_id")
    private Long ascriptionId;

    /**
     * 父部门id
     */
    private Long parentId;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 名称
     */
    private String name;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态（0正常 1停用）
     */
    private String status;
}

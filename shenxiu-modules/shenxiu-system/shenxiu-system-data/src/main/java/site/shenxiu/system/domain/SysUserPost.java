package site.shenxiu.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import site.shenxiu.common.core.web.domain.BaseEntity;

/**
 * 用户和岗位关联 sys_user_post
 *
 * @author ShenXiu
 * @version 2022/11/16 16:40
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("sys_user_post")
public class SysUserPost extends BaseEntity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private Long userId;

    /**
     * 岗位ID
     */
    private Long postId;

}

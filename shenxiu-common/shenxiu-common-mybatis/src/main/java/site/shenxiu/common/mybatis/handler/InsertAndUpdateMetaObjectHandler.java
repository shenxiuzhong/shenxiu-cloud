package site.shenxiu.common.mybatis.handler;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import site.shenxiu.common.core.constant.HttpStatus;
import site.shenxiu.common.core.domain.BaseEntity;
import site.shenxiu.common.core.exception.BusinessException;

import java.util.Date;

/**
 * 插入和更新共有元数据字段填充控制器
 *
 * @author shenxiu
 * @version 2022/12/2 13:36
 */
@Slf4j
public class InsertAndUpdateMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
                BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
                Date current = ObjectUtil.isNotNull(baseEntity.getCreateTime())
                        ? baseEntity.getCreateTime() : new Date();
                baseEntity.setCreateTime(current);
                baseEntity.setUpdateTime(current);
//                String username = StringUtils.isNotBlank(baseEntity.getCreateBy())
//                        ? baseEntity.getCreateBy() : getLoginUsername();
//                // 当前已登录 且 创建人为空 则填充
//                baseEntity.setCreateBy(username);
//                // 当前已登录 且 更新人为空 则填充
//                baseEntity.setUpdateBy(username);
            }
        } catch (Exception e) {
            throw new BusinessException("自动注入异常 => " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
                BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
                Date current = new Date();
                // 更新时间填充(不管为不为空)
                baseEntity.setUpdateTime(current);
                // String username = getLoginUsername();
                // 当前已登录 更新人填充(不管为不为空)
//                if (StringUtils.isNotBlank(username)) {
//                    baseEntity.setUpdateBy(username);
//                }
            }
        } catch (Exception e) {
            throw new BusinessException("自动注入异常 => " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}

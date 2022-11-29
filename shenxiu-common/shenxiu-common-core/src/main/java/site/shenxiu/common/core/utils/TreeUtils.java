package site.shenxiu.common.core.utils;

import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;

/**
 * 扩展hutool tree工具封装
 *
 * @author ShenXiu
 * @version 2022/11/25 11:06
 */
public class TreeUtils extends TreeUtil {
    /**
     * 根据前端定制差异化字段
     */
    public static final TreeNodeConfig DEFAULT_CONFIG = TreeNodeConfig.DEFAULT_CONFIG.setNameKey("label");


}

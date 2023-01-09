package site.shenxiu.common.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import site.shenxiu.common.core.exception.BusinessException;

/**
 * sql操作工具类
 *
 * @author shenxiu
 * @version 2022/11/29 17:23
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SqlUtils {

    /**
     * 定义常用的 sql关键字
     */
    public static final String SQL_REGEX = "select |insert |delete |update |drop |count |exec |chr |mid |master |truncate |char |and |declare ";

    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static final String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 检查字符，防止注入绕过
     *
     * @param sql sql
     * @return sql
     */
    public static String escapeOrderBySql(String sql) {
        if (StringUtils.isNotEmpty(sql) && !isValidOrderBySql(sql)) {
            throw new BusinessException("参数不符合规范，不能进行查询");
        }
        return sql;
    }

    /**
     * 验证 order by 语法是否符合规范
     *
     * @param sql sql
     * @return sql
     */
    public static boolean isValidOrderBySql(String sql) {
        return sql.matches(SQL_PATTERN);
    }

    /**
     * SQL关键字检查
     *
     * @param sql sql
     */
    public static void filterKeyword(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords) {
            if (StringUtils.indexOfIgnoreCase(sql, sqlKeyword) > -1) {
                throw new BusinessException("参数存在SQL注入风险");
            }
        }
    }
}

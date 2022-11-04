package site.shenxiu.common.core.constant;
/**
 * 常用html常量
 *
 * @author ShenXiu
 * @version 2022/11/1 12:41
 */
public interface HtmlConstants {

    /**
     * 字符串常量：HTML 空格转义 {@code "&nbsp;" -> " "}
     */
    String NBSP = XmlConstants.NBSP;

    /**
     * 字符串常量：HTML And 符转义 {@code "&amp;" -> "&"}
     */
    String AMP = XmlConstants.AMP;

    /**
     * 字符串常量：HTML 双引号转义 {@code "&quot;" -> "\""}
     */
    String QUOTE = XmlConstants.QUOTE;

    /**
     * 字符串常量：HTML 单引号转义 {@code "&apos" -> "'"}
     */
    String APOS = XmlConstants.APOS;

    /**
     * 字符串常量：HTML 小于号转义 {@code "&lt;" -> "<"}
     */
    String LT = XmlConstants.LT;

    /**
     * 字符串常量：HTML 大于号转义 {@code "&gt;" -> ">"}
     */
    String GT = XmlConstants.GT;

    /**
     * HTML标记 正则
     */
    String MARK_REGEX = "(<[^<]*?>)|(<[\\s]*?/[^<]*?>)|(<[^<]*?/[\\s]*?>)";

    /**
     * SCRIPT标记 正则
     */
    String SCRIPT_REGEX = "<[\\s]*?script[^>]*?>.*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
}

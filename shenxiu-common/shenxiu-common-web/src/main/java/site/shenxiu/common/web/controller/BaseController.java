package site.shenxiu.common.web.controller;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web层通用数据处理
 *
 * @author ShenXiu
 * @version 2022/11/3 17:27
 */
@Slf4j
public class BaseController {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;
}

package site.shenxiu.system.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.system.domain.SysDept;

import java.util.List;

/**
 * 部门 Api定义
 * @author ShenXiu
 * @version 2022/11/24 17:45
 * @definition 部门Api定义
 */
public interface SysDeptApi {

    /**
     * 获取部门列表
     * @param dept 部门
     * @return 列表数据
     */
    @GetMapping("/list")
    ResEntity<List<SysDept>> list(SysDept dept) ;

    /**
     * 查询部门列表（排除节点）
     *
     * @param deptId 部门ID
     * @return 列表数据
     */
    @GetMapping("/list/exclude/{deptId}")
    ResEntity<List<SysDept>> excludeChild(@PathVariable(value = "deptId", required = false) Long deptId);

    /**
     * 根据部门编号获取详细信息
     *
     * @param deptId 部门ID
     * @return 部门数据
     */
    @GetMapping(value = "/{deptId}")
    ResEntity<SysDept> getInfo(@PathVariable Long deptId);

    /**
     * 新增部门
     * @param dept 部门数据
     * @return 响应对象
     */
    @PostMapping(value = "/add")
    ResEntity<Void> add(@Validated @RequestBody SysDept dept);

    /**
     * 修改部门
     * @param dept 部门数据
     * @return 响应对象
     */
    @PostMapping(value = "/edit")
    ResEntity<Void> edit(@Validated @RequestBody SysDept dept) ;

    /**
     * 删除部门
     * @param deptId 部门ID
     * @return 响应对象
     */
    @PostMapping("/remove/{deptId}")
    ResEntity<Void> remove(@PathVariable Long deptId) ;
}

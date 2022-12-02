package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.domain.R;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.web.controller.BaseController;
import site.shenxiu.system.api.SysDictTypeApi;
import site.shenxiu.system.domain.SysDictType;
import site.shenxiu.system.service.SysDictTypeService;

import java.util.List;

/**
 * 字典类型 处置类
 * @author ShenXiu
 * @version 2022/11/30 16:11
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeController extends BaseController implements SysDictTypeApi {

    private final SysDictTypeService sysDictTypeService;


    @Override
    public R<PageData<SysDictType>> getPage(SysDictType dictType, PageQuery pageQuery) {
        return R.success(sysDictTypeService.selectPageDictTypeList(dictType, pageQuery));
    }

    @Override
    public void export(SysDictType dictType) {

    }

    @Override
    public R<SysDictType> getInfo(Long dictId) {
        return R.success(sysDictTypeService.selectDictTypeById(dictId));
    }

    @Override
    public R<Void> add(SysDictType dict) {
        if (SystemConstants.NOT_UNIQUE.equals(sysDictTypeService.checkDictTypeUnique(dict))) {
            return R.fail("新增字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        sysDictTypeService.insertDictType(dict);
        return R.success();
    }

    @Override
    public R<Void> edit(SysDictType dict) {
        if (SystemConstants.NOT_UNIQUE.equals(sysDictTypeService.checkDictTypeUnique(dict))) {
            return R.fail("修改字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        sysDictTypeService.updateDictType(dict);
        return R.success();
    }

    @Override
    public R<Void> remove(Long[] dictIds) {
        sysDictTypeService.deleteDictTypeByIds(dictIds);
        return R.success();
    }

    @Override
    public R<Void> refreshCache() {
        return null;
    }

    @Override
    public R<List<SysDictType>> optionselect() {
        return null;
    }
}

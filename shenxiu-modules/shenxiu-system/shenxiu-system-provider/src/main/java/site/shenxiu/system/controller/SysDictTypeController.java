package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.web.controller.BaseController;
import site.shenxiu.system.api.SysDictTypeApi;
import site.shenxiu.system.domain.SysDictType;
import site.shenxiu.system.service.SysDictTypeService;

import java.util.List;

/**
 * 字典类型 处置类
 * @author shenxiu
 * @version 2022/11/30 16:11
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeController extends BaseController implements SysDictTypeApi {

    private final SysDictTypeService sysDictTypeService;


    @Override
    public ResEntity<PageData<SysDictType>> getPage(SysDictType dictType, PageQuery pageQuery) {
        return ResEntity.success(sysDictTypeService.selectPageDictTypeList(dictType, pageQuery));
    }

    @Override
    public void export(SysDictType dictType) {

    }

    @Override
    public ResEntity<SysDictType> getInfo(Long dictId) {
        return ResEntity.success(sysDictTypeService.selectDictTypeById(dictId));
    }

    @Override
    public ResEntity<Void> add(SysDictType dict) {
        if (SystemConstants.NOT_UNIQUE.equals(sysDictTypeService.checkDictTypeUnique(dict))) {
            return ResEntity.fail("新增字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        sysDictTypeService.insertDictType(dict);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> edit(SysDictType dict) {
        if (SystemConstants.NOT_UNIQUE.equals(sysDictTypeService.checkDictTypeUnique(dict))) {
            return ResEntity.fail("修改字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        sysDictTypeService.updateDictType(dict);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> remove(Long[] dictIds) {
        sysDictTypeService.deleteDictTypeByIds(dictIds);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> refreshCache() {
        return null;
    }

    @Override
    public ResEntity<List<SysDictType>> optionselect() {
        return null;
    }
}

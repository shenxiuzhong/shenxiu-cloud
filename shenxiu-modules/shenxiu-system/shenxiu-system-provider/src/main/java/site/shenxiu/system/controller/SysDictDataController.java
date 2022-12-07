package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.web.controller.BaseController;
import site.shenxiu.system.api.SysDictDataApi;
import site.shenxiu.system.domain.SysDictData;
import site.shenxiu.system.service.SysDictDataService;

import java.util.List;

/**
 * 字典数据处置类
 * @author ShenXiu
 * @version 2022/11/30 16:14
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/data")
public class SysDictDataController extends BaseController implements SysDictDataApi {

    private final SysDictDataService sysDictDataService;

    @Override
    public ResEntity<PageData<SysDictData>> getPage(SysDictData dictData, PageQuery pageQuery) {
        return ResEntity.success(sysDictDataService.selectPageDictDataList(dictData,pageQuery));
    }

    @Override
    public void export(SysDictData dictData) {

    }

    @Override
    public ResEntity<SysDictData> getInfo(Long dictDataId) {
        return ResEntity.success(sysDictDataService.selectDictDataById(dictDataId));
    }

    @Override
    public ResEntity<List<SysDictData>> dictType(String dictType) {
        return ResEntity.success(sysDictDataService.selectDictDataByType(dictType));
    }

    @Override
    public ResEntity<Void> add(SysDictData dict) {
        sysDictDataService.insertDictData(dict);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> edit(SysDictData dict) {
        sysDictDataService.updateDictData(dict);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> remove(Long[] dictDataIds) {
        sysDictDataService.deleteDictDataByIds(dictDataIds);
        return ResEntity.success();
    }
}

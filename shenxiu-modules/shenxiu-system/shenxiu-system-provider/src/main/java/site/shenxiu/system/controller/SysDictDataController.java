package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.domain.R;
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
    public R<PageData<SysDictData>> getPage(SysDictData dictData, PageQuery pageQuery) {
        return R.success(sysDictDataService.selectPageDictDataList(dictData,pageQuery));
    }

    @Override
    public void export(SysDictData dictData) {

    }

    @Override
    public R<SysDictData> getInfo(Long dictDataId) {
        return R.success(sysDictDataService.selectDictDataById(dictDataId));
    }

    @Override
    public R<List<SysDictData>> dictType(String dictType) {
        return R.success(sysDictDataService.selectDictDataByType(dictType));
    }

    @Override
    public R<Void> add(SysDictData dict) {
        sysDictDataService.insertDictData(dict);
        return R.success();
    }

    @Override
    public R<Void> edit(SysDictData dict) {
        sysDictDataService.updateDictData(dict);
        return R.success();
    }

    @Override
    public R<Void> remove(Long[] dictDataIds) {
        sysDictDataService.deleteDictDataByIds(dictDataIds);
        return R.success();
    }
}

package site.shenxiu.system.service;

import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysDictData;

import java.util.List;

/**
* 针对表【sys_dict_data(字典数据表)】的数据库操作Service
* @author shenxiu
* @version 2022-11-24 15:15:42
*/
public interface SysDictDataService{

    /**
     * 根据条件分页查询字典数据
     * @param dictData 字典数据信息
     * @param pageQuery 分页信息
     * @return 分页字典数据
     */
    PageData<SysDictData> selectPageDictDataList(SysDictData dictData, PageQuery pageQuery);

    /**
     * 根据条件查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictDataId 字典数据ID
     * @return 字典数据
     */
    SysDictData selectDictDataById(Long dictDataId);

    /**
     * 批量删除字典数据信息
     *
     * @param dictDataIds 需要删除的字典数据ID
     */
    void deleteDictDataByIds(Long[] dictDataIds);

    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     */
    void insertDictData(SysDictData dictData);

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     */
    void updateDictData(SysDictData dictData);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataByType(String dictType);
}

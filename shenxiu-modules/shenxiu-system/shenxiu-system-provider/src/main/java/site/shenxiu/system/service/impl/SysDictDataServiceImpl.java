package site.shenxiu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.exception.BusinessException;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.mybatis.pagination.PageUtils;
import site.shenxiu.system.domain.SysDictData;
import site.shenxiu.system.mapper.SysDictDataMapper;
import site.shenxiu.system.service.SysDictDataService;

import java.util.Arrays;
import java.util.List;

/**
 * 针对表【sys_dict_data(字典数据表)】的数据库操作Service实现
 *
 * @author ShenXiu
 * @version 2022-11-24 15:15:42
 */
@RequiredArgsConstructor
@Service
public class SysDictDataServiceImpl implements SysDictDataService {

    private final SysDictDataMapper baseMapper;

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData  字典数据信息
     * @param pageQuery 分页信息
     * @return 分页字典数据
     */
    @Override
    public PageData<SysDictData> selectPageDictDataList(SysDictData dictData, PageQuery pageQuery) {
        LambdaQueryWrapper<SysDictData> lqw = new LambdaQueryWrapper<SysDictData>()
                .eq(StringUtils.isNotBlank(dictData.getDictType()), SysDictData::getDictType, dictData.getDictType())
                .like(StringUtils.isNotBlank(dictData.getDictLabel()), SysDictData::getDictLabel, dictData.getDictLabel())
                .eq(StringUtils.isNotBlank(dictData.getStatus()), SysDictData::getStatus, dictData.getStatus())
                .orderByAsc(SysDictData::getDictSort);
        Page<SysDictData> page = baseMapper.selectPage(PageUtils.build(pageQuery), lqw);
        return PageUtils.build(page);
    }

    /**
     * 根据条件查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataList(SysDictData dictData) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysDictData>()
                .eq(StringUtils.isNotBlank(dictData.getDictType()), SysDictData::getDictType, dictData.getDictType())
                .like(StringUtils.isNotBlank(dictData.getDictLabel()), SysDictData::getDictLabel, dictData.getDictLabel())
                .eq(StringUtils.isNotBlank(dictData.getStatus()), SysDictData::getStatus, dictData.getStatus())
                .orderByAsc(SysDictData::getDictSort));
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysDictData>()
                .select(SysDictData::getDictLabel)
                .eq(SysDictData::getDictType, dictType)
                .eq(SysDictData::getDictValue, dictValue))
                .getDictLabel();
    }

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictDataId 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictData selectDictDataById(Long dictDataId) {
        return baseMapper.selectById(dictDataId);
    }

    /**
     * 批量删除字典数据信息
     *
     * @param dictDataIds 需要删除的字典数据ID
     */
    @Override
    public void deleteDictDataByIds(Long[] dictDataIds) {
//        for (Long dictDataId : dictDataIds) {
//            SysDictData data = selectDictDataById(dictDataId);
//            baseMapper.deleteById(dictDataId);
//        }
        baseMapper.deleteBatchIds(Arrays.asList(dictDataIds));
    }

    /**
     * 新增保存字典数据信息
     *
     * @param data 字典数据信息
     */
    @Override
    public void insertDictData(SysDictData data) {
        int row = baseMapper.insert(data);
        if (row > 0) {
            return;
        }
        throw new BusinessException("操作失败");
    }

    /**
     * 修改保存字典数据信息
     *
     * @param data 字典数据信息
     */
    @Override
    public void updateDictData(SysDictData data) {
        int i = baseMapper.updateById(data);
        if (i > 0) {
            return;
        }
        throw new BusinessException("操作失败");
    }


    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysDictData>()
                .eq(StringUtils.isNotBlank(dictType), SysDictData::getDictType, dictType)
                .orderByAsc(SysDictData::getDictSort));
    }
}





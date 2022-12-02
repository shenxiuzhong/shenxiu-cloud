package site.shenxiu.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.exception.BusinessException;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.mybatis.pagination.PageUtils;
import site.shenxiu.system.domain.SysDictData;
import site.shenxiu.system.domain.SysDictType;
import site.shenxiu.system.mapper.SysDictDataMapper;
import site.shenxiu.system.mapper.SysDictTypeMapper;
import site.shenxiu.system.service.SysDictTypeService;

import java.util.Arrays;
import java.util.List;

/**
 * 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
 *
 * @author ShenXiu
 * @version 2022-11-24 15:15:48
 */
@RequiredArgsConstructor
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {

    private final SysDictTypeMapper baseMapper;
    private final SysDictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType  字典类型信息
     * @param pageQuery 分页查询信息
     * @return 分页数据
     */
    @Override
    public PageData<SysDictType> selectPageDictTypeList(SysDictType dictType, PageQuery pageQuery) {
        LambdaQueryWrapper<SysDictType> lqw = new LambdaQueryWrapper<SysDictType>()
                .like(StringUtils.isNotBlank(dictType.getDictName()), SysDictType::getDictName, dictType.getDictName())
                .eq(StringUtils.isNotBlank(dictType.getStatus()), SysDictType::getStatus, dictType.getStatus())
                .like(StringUtils.isNotBlank(dictType.getDictType()), SysDictType::getDictType, dictType.getDictType());
        Page<SysDictType> page = baseMapper.selectPage(PageUtils.build(pageQuery), lqw);
        return PageUtils.build(page);
    }

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictType dictType) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysDictType>()
                .like(StringUtils.isNotBlank(dictType.getDictName()), SysDictType::getDictName, dictType.getDictName())
                .eq(StringUtils.isNotBlank(dictType.getStatus()), SysDictType::getStatus, dictType.getStatus())
                .like(StringUtils.isNotBlank(dictType.getDictType()), SysDictType::getDictType, dictType.getDictType()));
    }

    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictType> selectDictTypeAll() {
        return null;
        //return baseMapper.selectList();
    }

//    /**
//     * 根据字典类型查询字典数据
//     *
//     * @param dictType 字典类型
//     * @return 字典数据集合信息
//     */
//    @Override
//    public List<SysDictData> selectDictDataByType(String dictType) {
////        List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(dictType);
////        if (CollUtil.isNotEmpty(dictDatas)) {
////            return dictDatas;
////        }
//        return null;
//    }

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        return baseMapper.selectById(dictId);
    }

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    @Override
    public SysDictType selectDictTypeByType(String dictType) {
        return baseMapper.selectById(new LambdaQueryWrapper<SysDictType>().eq(SysDictType::getDictType, dictType));
    }

    /**
     * 批量删除字典类型信息
     *
     * @param dictIds 需要删除的字典ID
     */
    @Override
    public void deleteDictTypeByIds(Long[] dictIds) {
        for (Long dictId : dictIds) {
            SysDictType dictType = selectDictTypeById(dictId);
            if (dictDataMapper.exists(new LambdaQueryWrapper<SysDictData>()
                    .eq(SysDictData::getDictType, dictType.getDictType()))) {
                throw new BusinessException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
        }
        baseMapper.deleteBatchIds(Arrays.asList(dictIds));
    }

    /**
     * 加载字典缓存数据
     */
    @Override
    public void loadingDictCache() {
        List<SysDictData> dictDataList = dictDataMapper.selectList(
                new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getStatus, SystemConstants.DICT_NORMAL));
        //Map<String, List<SysDictData>> dictDataMap = StreamUtils.groupByKey(dictDataList, SysDictData::getDictType);
//        dictDataMap.forEach((k,v) -> {
//            List<SysDictData> dictList = StreamUtils.sorted(v, Comparator.comparing(SysDictData::getDictSort));
//            CacheUtils.put(CacheNames.SYS_DICT, k, dictList);
//        });
    }

    /**
     * 清空字典缓存数据
     */
    @Override
    public void clearDictCache() {
        // CacheUtils.clear(CacheNames.SYS_DICT);
    }

    /**
     * 重置字典缓存数据
     */
    @Override
    public void resetDictCache() {
        clearDictCache();
        loadingDictCache();
    }

    /**
     * 新增保存字典类型信息
     *
     * @param dict 字典类型信息
     */
//    @CachePut(cacheNames = CacheNames.SYS_DICT, key = "#dict.dictType")
    @Override
    public void insertDictType(SysDictType dict) {
        int row = baseMapper.insert(dict);
        if (row > 0) {
            return;
        }
        throw new BusinessException("操作失败");
    }

    /**
     * 修改保存字典类型信息
     *
     * @param dict 字典类型信息
     */
//    @CachePut(cacheNames = CacheNames.SYS_DICT, key = "#dict.dictType")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDictType(SysDictType dict) {
        SysDictType oldDict = baseMapper.selectById(dict.getDictId());
        dictDataMapper.update(null, new LambdaUpdateWrapper<SysDictData>()
                .set(SysDictData::getDictType, dict.getDictType())
                .eq(SysDictData::getDictType, oldDict.getDictType()));
        int row = baseMapper.updateById(dict);
        if (row > 0) {
            return;
//            CacheUtils.evict(CacheNames.SYS_DICT, oldDict.getDictType());
        }
        throw new BusinessException("操作失败");
    }

    /**
     * 校验字典类型称是否唯一
     *
     * @param dict 字典类型
     * @return 结果
     */
    @Override
    public String checkDictTypeUnique(SysDictType dict) {
        boolean exist = baseMapper.exists(new LambdaQueryWrapper<SysDictType>()
                .eq(SysDictType::getDictType, dict.getDictType())
                .ne(ObjectUtil.isNotNull(dict.getDictId()), SysDictType::getDictId, dict.getDictId()));
        if (exist) {
            return SystemConstants.NOT_UNIQUE;
        }
        return SystemConstants.UNIQUE;
    }
}





package com.wx.scheduled.utils;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//使用通用mapper配置的公共接口
public interface MapperUtil<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
    /*//新增返回主键到对象中
    int insertUseGeneratedKeys(T t);

    //修改按照主键更新
    int updateByPrimaryKeySelective(T t);

    //根据主键查询
    T selectByPrimaryKey(Object id);

    //根据对象中的属性名称查询：
    // 根据T对象中的属性名称查询,类似于select * from table where t.username=xxx and t.mobile = xxxx
    List<T> select(T t);
    //根据自定义条件查找
    *//***
     * Example example = new Example(WorkCategoryEntity.class);
     * example.setOrderByClause("sort ASC");
     * // 创建Criteria
     * Example.Criteria criteria = example.createCriteria();
     *   // 添加条件
     * criteria.andEqualTo("pid", pid);
     * criteria.andEqualTo("isDelete", WorkCategoryEntity.IsDeleteEnum.INIT.getCode());
     * List<WorkCategoryEntity> list = workCategoryMapper.selectByExample(example);
     */


}

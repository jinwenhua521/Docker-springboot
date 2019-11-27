package com.jwh.testMp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MyMapper<T> extends BaseMapper<T> {

    /**
     * 删除所有  返回影响行数
     * @return
     */
    int deleteAll();

    int insertBatchSomeColumn(List<T> list);

    int deleteByIdWithFill(T entity);
}

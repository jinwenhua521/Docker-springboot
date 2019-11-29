package com.jwh.testMp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jwh.testMp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lazzaro
 * @since 2019-11-25
 */
public interface UserMapper extends MyMapper<User> {

    //控制是否启用多租户  true不启用 默认false
    //@SqlParser(filter = true)
    @Select("select * from user ${ew.customSqlSegment}")
    public List<User> mySelectList(@Param(Constants.WRAPPER)Wrapper<User> wrapper);


}

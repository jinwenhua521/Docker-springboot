package com.jwh.testMp.commponent;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Strings;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;

/**
 * mp自动填充填充处理器
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("create_time");
        if(hasSetter){
            System.out.println("自动填充插入处理器");
            setInsertFieldValByName("create_time", LocalDateTime.now(),metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("update_time");
        Object val = getFieldValByName("update_time", metaObject);
        if(null == val){  //为null才使用自动填充
            if(hasSetter) {
                System.out.println("自动填充更新处理器");
                setUpdateFieldValByName("update_time", LocalDateTime.now(), metaObject);
            }
        }
    }


}

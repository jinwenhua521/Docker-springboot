package com.jwh.testMp.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class DeleteMethod  extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "update "+ tableInfo.getTableName()+" set deleted = 0 ";
        //mapper 接口方法名
        String methodName = "deleteAll";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        return addDeleteMappedStatement(mapperClass,methodName,sqlSource);
    }
}

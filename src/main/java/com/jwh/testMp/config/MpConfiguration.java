package com.jwh.testMp.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 3.1以后不需要这个配置了
 */
@Configuration
@MapperScan("com.jwh.testMp.mapper")
public class MpConfiguration {

    public  static  ThreadLocal<String> myTableName = new ThreadLocal<>();

    /**
     * 注册分页插件   配置多租户
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        ArrayList<ISqlParser> iSqlParsers = new ArrayList<>();
        //多租户SQL解析器
        /*TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId() {
                return new LongValue(1087982257332887553L);
            }

            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                if("role".equals(tableName)){
                    return  true;
                }
                return false;
            }
        });
        iSqlParsers.add(tenantSqlParser);*/

        //动态sql解析器
        DynamicTableNameParser dtp = new DynamicTableNameParser();
        Map<String, ITableNameHandler> map = new HashMap<>();
        map.put("user", new ITableNameHandler() {
            @Override
            public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                return myTableName.get();
            }
        });
        dtp.setTableNameHandlerMap(map);
        iSqlParsers.add(dtp);

        paginationInterceptor.setSqlParserList(iSqlParsers);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                if("com.jwh.testMp.mapper.UserMapper.selectById".equals(ms.getId())){
                    return  true;
                }
                return false;
            }
        });
        return paginationInterceptor;
    }


    /*@Bean
    public ISqlInjector iSqlInjector(){
        return new LogicSqlInjector();
    }*/

    /**
     * 配置乐观锁插件
     * @return OptimisticLockerInterceptor
     */
    @Bean
    public OptimisticLockerInterceptor lockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }


    /**
     * 性能分析插件
     * @return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        //performanceInterceptor.setMaxTime(5L);
        return performanceInterceptor;
    }
}

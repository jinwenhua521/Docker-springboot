package com.jwh.testMp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import com.jwh.testMp.method.DeleteMethod;
import org.springframework.stereotype.Component;

import java.util.List;

//自定义注入器
@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        methodList.add(new DeleteMethod());
        methodList.add(new InsertBatchSomeColumn(t->!t.isLogicDelete()&&!t.getColumn().equals("age")));
        methodList.add(new LogicDeleteByIdWithFill());
        return methodList;
    }
}

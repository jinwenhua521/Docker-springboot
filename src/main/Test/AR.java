import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jwh.MpGaojiApplication;
import com.jwh.testMp.config.MpConfiguration;
import com.jwh.testMp.entity.User;
import com.jwh.testMp.mapper.UserMapper;
import com.jwh.testMp.service.IUserService;
import com.jwh.testMp.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpGaojiApplication.class)
public class AR {


    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserService iUserService;

    @org.junit.Test
    public void testSelect(){
        MpConfiguration.myTableName.set("user_20199");
        List<User> users = userMapper.mySelectList(Wrappers.<User>lambdaQuery().isNotNull(true,User::getAge));
        users.forEach(System.out::println);
    }

    @org.junit.Test
    public void testSelect2(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @org.junit.Test
    public void testByID(){
        User user = userMapper.selectById(1199242689724379138L);
        System.out.println(user);
    }


    @org.junit.Test
    public void testDelById() {
        int count = userMapper.deleteById("1094592041087729666");
        System.out.println("影响行数：" + count);
    }

    @org.junit.Test
    public void updateByid() {
        boolean update = iUserService.update(Wrappers.<User>lambdaUpdate().eq(User::getId, 1088248166370832385L).set(User::getAge, "28"));
        System.out.println("是否成功：" + update);
    }

    @org.junit.Test
    public void insterTest(){
        User user = new User();
        user.setName("jwh2");
        user.setAge(56);
        user.setEmail("jwh2@baomidou.com");
        //user.setManager_id(1088248166370832385L);
        int insert = userMapper.insert(user);
        System.out.println("影响行数" + insert);
    }

    @org.junit.Test
    public void updateTest(){
        User user = new User();
        user.setAge(23);
        user.setId(1088248166370832385L);
        //user.setUpdate_time(LocalDateTime.now());
        int insert = userMapper.updateById(user);
        System.out.println("影响行数" + insert);
    }

    @org.junit.Test
    public void optTest(){
        int version = 5;
        User user = new User();
        user.setAge(30);
        user.setId(1199169183888269313L);
        user.setVersion(version);
        int insert = userMapper.updateById(user);
        System.out.println("影响行数" + insert);
    }


    @org.junit.Test
    public void testDeleteAll(){
        int insert = userMapper.deleteAll();
        System.out.println("影响行数" + insert);
    }


    @org.junit.Test
    public void insertBachTest(){
        User user = new User();
        user.setName("李伟1");
        user.setAge(30);
        user.setManager_id(1199242689724379138L);

        User user2 = new User();
        user2.setName("李伟2");
        user2.setAge(30);
        user2.setManager_id(1199242689724379138L);

        List<User> users = Arrays.asList(user, user2);

        int insert = userMapper.insertBatchSomeColumn(users);
        System.out.println("影响行数" + insert);
    }

    @org.junit.Test
    public void DeleteTest(){
        User user = new User();
        user.setId(1199503244687106049L);
        user.setAge(21);

        User user2 = new User();
        user2.setId(1199503244708077569L);
        user2.setAge(21);

        List<User> users = Arrays.asList(user, user2);

        int insert = userMapper.deleteByIdWithFill(user2);
        System.out.println("影响行数" + insert);
    }

}

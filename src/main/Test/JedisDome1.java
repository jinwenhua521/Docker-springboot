import com.jwh.MpGaojiApplication;
import com.jwh.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpGaojiApplication.class)
public class JedisDome1 {

    @Autowired(required=true)
    private RedisUtil redisUtil;

    @Test
    public void Test1(){
        System.out.println(redisUtil.get("a1"));
        //System.out.println(redisUtil.hget("m1","username"));
        System.out.println(redisUtil.hHasKey("m2", "username"));
        System.out.println(redisUtil.keys("m2"));
    }
}

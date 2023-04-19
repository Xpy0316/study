package cn.study.web;

import cn.study.common.utils.http.MyHttpClient;
import cn.study.web.domain.TestDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SimpleTest
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/14 16:36
 * @Version 1.0
 */
@SpringBootTest
public class SimpleTest {

    @Autowired
    private MyHttpClient client;

    @Test
    public void doPostTest(){
        TestDomain testDomain = new TestDomain();
        testDomain.setType("0");
        testDomain.setMainTableId("8888");

        Map<String, Object> stringObjectMap = client.doPost("http://127.0.0.1:8092/wp/createOrForbiddenAD", "", testDomain);
        System.out.println(stringObjectMap);

    }
}

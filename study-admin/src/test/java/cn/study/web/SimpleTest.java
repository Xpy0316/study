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

        Map<String, Object> stringObjectMap = client.doPost("http://10.10.201.238:8092/wp/createOrForbiddenAD", "", testDomain);
        System.out.println(stringObjectMap);


        Map map = new HashMap();
        map.put("code","95ebd75b53314807b0b868f3a4802a80");
        Map<String, Object> stringObjectMap2 = client.doGet("https://empauto.diezhi.net:8010/auto/system/userInfoByScanCode",map);
        System.out.println(stringObjectMap2);


    }
}

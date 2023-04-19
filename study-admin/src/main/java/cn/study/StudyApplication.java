package cn.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName StudyApplication
 * @Description TODO
 * @Author v-xupengyuan
 * @Date 2023/4/14 16:28
 * @Version 1.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ ");
    }
}

package cn.study.common.utils.http;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import org.springframework.stereotype.Component;
import retrofit2.http.*;

import java.util.Map;

/**
 * @ClassName MyHttpClient
 * @Description http请求工具接口类
 * @Author v-xupengyuan
 * @Date 2023/4/14 15:46
 * @Version 1.0
 */
@Component
@RetrofitClient(baseUrl = "https://www.baidu.com/")
public interface MyHttpClient {

    /**
     * @Description: 处理post请求 简单请求头->携带单个授权Authorization
     * @param url
     * @param token
     * @param data
     * @return
     */
    @POST
    @Retry(intervalMs = 5000,maxRetries = 3)
    Map<String,Object> doPost(@Url String url,
                                     @Header("Authorization") String token,
                                     @Body Object data);

    /**
     * @Description: 处理post请求 复杂请求头
     * @param url
     * @param head
     * @param data
     * @return
     */
    @POST
    @Retry(intervalMs = 5000,maxRetries = 3)
    Map<String,Object> doPost(@Url String url,
                                      @HeaderMap Map<String,String> head,
                                      @Body Object data);

    /**
     * 处理get请求
     * @param url
     * @return
     */
    @GET
    @Retry(intervalMs = 5000,maxRetries = 3)
    Map<String,Object> doGet(@Url String url);

    /**
     * 处理get请求 请求头->携带授权Authorization
     * @param url
     * @param token
     * @return
     */
    @GET
    @Retry(intervalMs = 5000,maxRetries = 3)
    Map<String,Object> doGet(@Url String url,@Header("Authorization") String token);

}

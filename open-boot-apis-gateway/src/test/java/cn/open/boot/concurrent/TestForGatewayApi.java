package cn.open.boot.concurrent;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * 网关接口测试
 * Created by qianlu on 2017/7/10.
 */
public class TestForGatewayApi {

    public static void main(String[] args) {
        CurrentThread t1 = new CurrentThread();
        CurrentThread t2 = new CurrentThread();
        CurrentThread t3 = new CurrentThread();
        CurrentThread t4 = new CurrentThread();
        CurrentThread t5 = new CurrentThread();
        CurrentThread t6 = new CurrentThread();
        CurrentThread t7 = new CurrentThread();
        CurrentThread t8 = new CurrentThread();

        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();
        t6.run();
        t7.run();
        t8.run();
    }
}

class CurrentThread extends Thread {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://localhost:8000/apis-u/add?a=2&b=3");
            httpGet.addHeader("authorization", "auth");
            httpGet.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
            try {
                HttpResponse res = closeableHttpClient.execute(httpGet);
                String rtn = EntityUtils.toString(res.getEntity());
            } catch (Exception e) {
            } finally {
                httpGet.releaseConnection();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

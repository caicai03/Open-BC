package cn.open.boot.concurrent;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * Created by lenovo on 2017/7/10.
 */
public class TestForApi {
    public static void main(String[] args) {
        CurrentApiThread t1 = new CurrentApiThread();
        CurrentApiThread t2 = new CurrentApiThread();
        CurrentApiThread t3 = new CurrentApiThread();
        CurrentApiThread t4 = new CurrentApiThread();
        CurrentApiThread t5 = new CurrentApiThread();
        CurrentApiThread t6 = new CurrentApiThread();
        CurrentApiThread t7 = new CurrentApiThread();
        CurrentApiThread t8 = new CurrentApiThread();

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

class CurrentApiThread extends Thread {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://localhost:8001/add?a=2&b=3");
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


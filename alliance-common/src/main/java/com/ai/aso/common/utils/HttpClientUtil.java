package com.ai.aso.common.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.exception.RestServiceRespFailedException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String post(String url, String parameters) {
        logger.debug("restService访问：url:" + url + ",parameters:" + parameters);


        CloseableHttpClient httpClient = null;
        HttpPost method = null;
        String body = null;
        int statusCode = 0;

        try {
            if (StringUtil.isNotEmpty(url)) {
                httpClient = HttpClients.createDefault();
                method = new HttpPost(url);
            }

            if (method != null && parameters != null && !"".equals(parameters.trim())) {
                // 建立一个NameValuePair数组，用于存储欲传送的参数
                method.addHeader("Content-type", "application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));

                long startTime = System.currentTimeMillis();
                HttpResponse response = httpClient.execute(method);
                long endTime = System.currentTimeMillis();
                statusCode = response.getStatusLine().getStatusCode();

                logger.info("statusCode:" + statusCode);
                logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                if (statusCode != HttpStatus.SC_OK) {
                    logger.error("Method failed:{}", response.getStatusLine());
                    logger.error("Method failed:{}", EntityUtils.toString(response.getEntity()));
                    throw new RestServiceRespFailedException();
                }
                // Read the response body
                body = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (IOException e) {
            // 网络错误
            logger.error("RestService访问{}，网络错误", url);
            throw new RestServiceRespFailedException();
        } finally {
            logger.info("调用接口状态：" + statusCode);
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    logger.error("关闭httpClient失败！", e);
                }
            }
        }

        return body;
    }

    public static void main(String[] args) {
        // 接口地址
        String apiURL = "http://192.168.3.67:8080/lkgst_manager/order/order";
        JSONArray arry = new JSONArray();
        JSONObject j = new JSONObject();
        j.put("orderId", "中文");
        j.put("createTimeOrder", "2015-08-11");
        arry.add(j);
        System.out.println(HttpClientUtil.post(apiURL, arry.toString()));
    }
}

package n3.snail.httpclient;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author N3 on 2017/3/5.
 */
public class HttpClientUtil
{
    private static final CloseableHttpClient httpClient;
    private static final PoolingHttpClientConnectionManager connectionManager;
    private static final int DEFAULT_CONNECT_TIMEOUT = 3000;
    private static final int DEFAULT_READ_TIMEOUT = 10000;
    private static final int DEFAULT_RETRY_TIME = 1;

    static {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
                .setSocketTimeout(DEFAULT_READ_TIMEOUT)
                .build();
        connectionManager = new PoolingHttpClientConnectionManager();
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                //不设置时默认带连接池，设置为basic类型则不带连接池
                .setConnectionManager(connectionManager)
                .disableAutomaticRetries()
                .build();
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    connectionManager.closeExpiredConnections();
                    connectionManager.closeIdleConnections(1, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2, 2, TimeUnit.SECONDS);
    }
    private HttpClientUtil()
    {
    }

    public static String executePost(String url, Map<String, String> params)
    {
        return executePost(url, params, "utf-8");
    }

    public static String executePost(String url, Map<String, String> params, String charset)
    {
        return executePost(url, null, params, charset);
    }

    public static String executePost(String url, Map<String, String> headers, Map<String, String> params, String charset)
    {
        List<Header> headerList = null;
        if (headers != null && !headers.isEmpty())
        {
            headerList = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (params != null && !params.isEmpty())
        {
            for (Map.Entry<String, String> param : params.entrySet())
            {
                nameValuePairs.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
        }
        HttpEntity httpEntity = null;
        try
        {
            httpEntity = new UrlEncodedFormEntity(nameValuePairs, charset);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            throw new NetConnectionException("Connect to url[" + url + "] error", e);
        }
        return executePost(url, headerList, httpEntity, charset);
    }

    public static String executePost(String url, List<Header> headers, HttpEntity entity, String charset)
    {
        CloseableHttpClient httpClient = null;
        HttpPost post = null;
        CloseableHttpResponse response = null;
        long timeStart = System.currentTimeMillis();
        try
        {
            httpClient = getDefaultClient();
            post = new HttpPost(url);

            if (headers != null && !headers.isEmpty())
            {
                for (Header header : headers)
                {
                    post.addHeader(header);
                }
            }

            post.setEntity(entity);
            response = httpClient.execute(post); // 发送Http请求
            int httpStatusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == httpStatusCode)
            {
                HttpEntity resEntity = response.getEntity();

                String result = EntityUtils.toString(resEntity, charset);
                System.out.println("HttpResponse=" + result);
                return result;
            }
            else
            {
                System.out.println(url + "|ResponseCode=" + httpStatusCode);
                throw new NetConnectionException("Connect to url[" + url + "] error, response code is "
                        + httpStatusCode);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new NetConnectionException("Connect to url[" + url + "] error", e);
        }
        finally
        {
            long timeEnd = System.currentTimeMillis();
            System.out.println("cost " + (timeEnd - timeStart) + " millionseconds");
//            if(httpClient != null && httpClient.getConnectionManager() != null)
//            {
//                httpClient.getConnectionManager().closeIdleConnections(0, TimeUnit.MILLISECONDS);
//            }
            if (response != null)
            {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static CloseableHttpClient getDefaultClient()
    {
        return httpClient;
    }
}

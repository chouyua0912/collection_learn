package z.learn.httpcore;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * http://hc.apache.org/httpcomponents-client-ga/tutorial/html/fundamentals.html#d5e95
 * HTTP entity 用于绑定消息，包括三种
 * HttpClient distinguishes three kinds of entities, depending on where their content originates:
 * <p>
 * streamed:  The content is received from a stream, or generated on the fly. In particular,
 * this category includes entities being received from HTTP responses. Streamed entities are generally not repeatable.
 * self-contained:  The content is in memory or obtained by means that are independent from a connection or other entity.
 * Self-contained entities are generally repeatable. This type of entities will be mostly used for entity enclosing HTTP requests.
 * wrapping:  The content is obtained from another entity.
 * <p>
 * An entity can be repeatable, meaning its content can be read more than once.
 * This is only possible with self contained entities (like ByteArrayEntity or StringEntity)
 */
public class HttpClientSample {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            System.out.println(response1.getAllHeaders());
            EntityUtils.consume(entity1);
        } finally {
            response1.close();      // 必须显式的释放连接
        }

        HttpPost httpPost = new HttpPost("http://localhost:8080");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        StringEntity stringEntity = new StringEntity("{a:\"abc\"}", ContentType.APPLICATION_JSON);
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
    }
}

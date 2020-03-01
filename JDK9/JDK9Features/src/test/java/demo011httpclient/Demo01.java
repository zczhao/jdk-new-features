package demo011httpclient;

import java.net.URI;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

public class Demo01 {

   @Test
    public void test01() throws Exception{
        // 1、创建HttpClient的对象
        HttpClient httpClient = HttpClient.newHttpClient();
        // 2、创建请求的构造器
        HttpRequest.Builder builder = HttpRequest.newBuilder(new URI("http://www.baidu.com"));
        // 3、使用请求构造器构建请求，并且设置请求的参数
        HttpRequest request = builder.header("user-agent", "zczhao").GET().build();
        // 4、使用HttpClient发送请求，并且得到响应的对象
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandler.asString());
        // 5、查看响应对象的信息
        System.out.println("响应的状态码：" + response.statusCode());
        System.out.println("响应的信息：" + response.body());
    }

}

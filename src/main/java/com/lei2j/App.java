package com.lei2j;


import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public void mainHandler(String event) throws IOException {
        Request request = new Request.Builder()
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36 Edg/100.0.1185.36")
                .addHeader("referer", Constants.BASE_URL)
                .addHeader("x-requested-with", "XMLHttpRequest")
                .url("https://www.hifini.com/sg_sign.htm")
                .post(RequestBody.create(MediaType.get(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE), ""))
                .build();
        Response response = OkHttpUtils.get().newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Http request error:" + response.code() + ":" + response.message());
        }
        if (response.body() != null) {
            System.out.println(response.body().string());
        }
    }

}

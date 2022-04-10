package com.lei2j;

import okhttp3.*;
import okhttp3.internal.http.BridgeInterceptor;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leijinjun
 * @date 2022/4/9
 **/
public class OkHttpUtils {

    private static final OkHttpClient HTTP_CLIENT;

    static {
        HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(15))
                .connectionPool(new ConnectionPool())
                .addInterceptor(new BridgeInterceptor(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        String bbsSid = System.getenv(Constants.COOKIE_BBS_SID) == null ? System.getProperty(Constants.COOKIE_BBS_SID) : System.getenv(Constants.COOKIE_BBS_SID);
                        String bbsToken = System.getenv(Constants.COOKIE_BBS_TOKEN) == null ? System.getProperty(Constants.COOKIE_BBS_TOKEN) : System.getenv(Constants.COOKIE_BBS_TOKEN);
                        return Stream.of(new Cookie.Builder().name(Constants.COOKIE_BBS_SID).value(bbsSid).domain("www.hifini.com").path("/").build(),
                                new Cookie.Builder().name(Constants.COOKIE_BBS_TOKEN).value(bbsToken).domain("www.hifini.com").path("/").build())
                                .collect(Collectors.toList());
                    }
                }))
                .build();
    }

    public static OkHttpClient get() {
        return HTTP_CLIENT;
    }
}

package com.example.administrator.mytemplateapplication.network.api;

import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.network.RetrofitClientForTest;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.BufferedSource;
import okio.Okio;

import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2017/12/27.
 */
@RunWith(JUnit4.class)
public class TestServiceTest {

    private TestService testService;

    private MockWebServer mockWebServer;

    private HomeRec homeRec;


    @Before
    public void createService() throws IOException {
        mockWebServer = new MockWebServer();
        testService = new RetrofitClientForTest(mockWebServer.url("/")).create(TestService.class);

    }

    @After
    public void stopService() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void getHomeIndex() throws Exception {
        enqueueResponse("test.json", Collections.emptyMap());
        testService.getHomeIndex().subscribe(new Observer<HttpResult<HomeRec>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(HttpResult<HomeRec> homeRecHttpResult) {
                homeRec = homeRecHttpResult.getData();
                assertThat(homeRec.getTitle(), CoreMatchers.is("借薪卡"));
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void enqueueResponse(String fileName, Map<String, String> headers) throws IOException {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("api-response/" + fileName);
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            mockResponse.addHeader(header.getKey(), header.getValue());
        }
        mockWebServer.enqueue(mockResponse
                .setBody(source.readString(StandardCharsets.UTF_8)));
    }
}
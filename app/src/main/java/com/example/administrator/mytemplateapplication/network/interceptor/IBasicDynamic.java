package com.example.administrator.mytemplateapplication.network.interceptor;

import java.util.Map;

public interface IBasicDynamic {
    String signParams(String postBodyString);
    Map signParams(Map map);
    Map signHeadParams(Map headMap);
}

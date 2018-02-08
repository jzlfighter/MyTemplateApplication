package com.example.administrator.mytemplateapplication.network.entity;

import java.util.List;

@SuppressWarnings("unused")
public class ListData<T> extends PageMo {
    /** list数据 */
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

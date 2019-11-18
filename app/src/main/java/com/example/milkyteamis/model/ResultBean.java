package com.example.milkyteamis.model;

import java.util.List;

public class ResultBean {
    private int status;
    private List<Good> data;

    public ResultBean(int status, List<Good> data) {
        this.status = status;
        this.data = data;
    }



    public List<Good> getData() {
        return data;
    }


}

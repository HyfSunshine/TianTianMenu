package com.tiantian.menu.models;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MenuType {

    /**
     * code : 200
     * data : [{"classid":2,"name":"减肥"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * classid : 2
         * name : 减肥
         */

        private int classid;
        private String name;

        public int getClassid() {
            return classid;
        }

        public void setClassid(int classid) {
            this.classid = classid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

package com.tiantian.menu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MenuType implements Parcelable {

    /**
     * code : 200
     * data : [{"classid":2,"name":"减肥"}]
     */

    private int code;
    private ArrayList<DataBean> data;

    protected MenuType(Parcel in) {
        code = in.readInt();
    }

    public static final Creator<MenuType> CREATOR = new Creator<MenuType>() {
        @Override
        public MenuType createFromParcel(Parcel in) {
            return new MenuType(in);
        }

        @Override
        public MenuType[] newArray(int size) {
            return new MenuType[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
    }

    public static class DataBean implements Parcelable {
        /**
         * classid : 2
         * name : 减肥
         */

        private int classid;
        private String name;

        protected DataBean(Parcel in) {
            classid = in.readInt();
            name = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(classid);
            parcel.writeString(name);
        }
    }
}

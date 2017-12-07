package com.tiantian.menu.baseinterface;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */

public interface M2VListener<T> {
    void ntfSuccess(T t);
    void ntfSuccess(List<T> list);
    void ntfFailed();
}

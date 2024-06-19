package com.swalktech.cloud.cloudcommon.function;

@FunctionalInterface
public interface BeanCopyCallBack<S, T> {
    void callBack(S t, T s);
}

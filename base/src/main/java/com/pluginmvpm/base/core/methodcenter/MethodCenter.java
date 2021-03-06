package com.pluginmvpm.base.core.methodcenter;

import android.content.Context;

import com.pluginmvpm.base.BaseLog;
import com.pluginmvpm.base.core.SynResult;

/**
 * Created by wangshizhan on 17/4/7.
 */

public class MethodCenter extends BaseMethodCenter {


    public MethodCenter(Context context){
        super(context);
    }


    /**
     * 调用同步方法
     * @param method 方法名
     * @param arg 可变参数
     */
    public void callMethodVoid(String method, Object... arg){

        if(isASynMethod(method)){
            callASynMethod(method, arg);
        }
        else{
            callMethodVoid(method, arg);
        }

    }

    /**
     * 调用同步方法
     * @param method 方法名
     * @param arg 可变参数
     */
    protected void callSynMethodVoid(String method, Object... arg){

        BaseLog.i("callSynMethodViod");

        SynResult<String> result = (SynResult<String>) callSynMethod(method, arg);

        if("null".equals(result.value())){
            //success
        }
        else if("error".equals(result.value())){
            BaseLog.e("callSynMethodVoid  error!");
        }

    }


    /**
     * 调用同步方法
     * @param method 方法名
     * @param arg 可变参数
     * @return bool
     */
    public  boolean callMethodBoolean(String method, Object... arg){

        BaseLog.i("callSynMethodBoolean");

        SynResult<Boolean> result = (SynResult<Boolean>)callSynMethod(method, arg);

        if(result == null ){
            return false;
        }
        return result.value();
    }

    /**
     * 调用同步方法
     * @param method
     * @param arg
     * @return int
     */
    public int callMethodInt(String method, Object... arg){

        SynResult<Integer> result = (SynResult<Integer>) callSynMethod(method, arg);

        if(result == null){
            return -1;
        }
        return result.value();
    }

    /**
     * 调用同步方法
     * @param method
     * @param arg
     * @return String
     */
    public  String callMethodString(String method, Object... arg){

        SynResult<String> result = (SynResult<String>) callSynMethod(method, arg);

        if(result == null){
            return "";
        }
        return result.value();
    }


}

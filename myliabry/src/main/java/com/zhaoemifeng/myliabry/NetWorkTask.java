package com.zhaoemifeng.myliabry;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/5/31
 */
public class NetWorkTask extends AsyncTask<String,Integer,byte[]> {
    private Context mContext;
    private NetworkTaskCallback mCallback;
    public  NetWorkTask(Context context,NetworkTaskCallback callback){
        mContext=context;
        mCallback=callback;
    }
    @Override
    protected byte[] doInBackground(String... params) {
        byte[] ret=null;
        if (params != null) {
            int len=params.length;
            if(len>0){
                //TODO:每一次执行网络请求之前，建议检测网络，如果没有网络就不加载了
                ConnectivityManager manager=
                        (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                //返回null 代表飞行模式

                NetworkInfo info = manager.getActiveNetworkInfo();
                if (info != null) {
                    //TODO:联网
                    ret=HttpTools.doGet(params[0]);
                }
            }
        }

        return ret;
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        if (mCallback != null) {
            mCallback.onTaskFinnished(bytes);
        }
    }
}

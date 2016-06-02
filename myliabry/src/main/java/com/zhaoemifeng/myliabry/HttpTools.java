package com.zhaoemifeng.myliabry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/5/31
 */
public final class HttpTools {
    private static InputStream stream;

    private HttpTools() {

    }

    public static byte[] doGet(String url) {
        byte[] ret = null;
        //技巧：1方法永远只有一个return
        //     2优先检查参数
        if (url != null) {
            HttpURLConnection conn = null;
            InputStream stream = null;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(3000);
                conn.connect();
                int stateCode = conn.getResponseCode();

                if (stateCode == 200) {
                    stream = conn.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024];
                    int len;
                    while (true) {
                        len = stream.read(b);
                        if (len == -1) {
                            break;
                        }
                        bos.write(b, 0, len);
                    }
                    ret = bos.toByteArray();
                    bos.close();
                    b = null;


                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    conn.disconnect();
                }
            }

        }


        return ret;
    }
}

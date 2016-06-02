package com.zhaoemifeng.test.fragments.homes;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoemifeng.myliabry.NetWorkTask;
import com.zhaoemifeng.myliabry.NetworkTaskCallback;
import com.zhaoemifeng.test.R;
import com.zhaoemifeng.test.modle.TextFile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * A simple {@link Fragment} subclass.
 */
public class File1Fragment extends Fragment implements NetworkTaskCallback {
    private TextFile mTextFile;
    private TextView txt_assay_title, txt_assay_author, txt_assay_authorbrief, txt_assay_times, txt_assay_summary, txt_assay_text;

    public File1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextFile = new TextFile();
        Bundle bundle = getArguments();
        String id1 = bundle.getString("assay1");
        Log.d("test", id1);
        //TODO:加载网络
        NetWorkTask task = new NetWorkTask(getContext(), this);
        task.execute("http://api.shigeten.net/api/Novel/GetNovelContent?id=" + id1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_file1, container, false);
        txt_assay_author = (TextView) inflate.findViewById(R.id.txt_assay_author);
        txt_assay_authorbrief = (TextView) inflate.findViewById(R.id.txt_assay_authorbrief);
        txt_assay_summary = (TextView) inflate.findViewById(R.id.txt_assay_summary);
        txt_assay_text = (TextView) inflate.findViewById(R.id.txt_assay_text);
        txt_assay_times = (TextView) inflate.findViewById(R.id.txt_assay_author2);
        txt_assay_title = (TextView) inflate.findViewById(R.id.txt_assay_title);
        return inflate;
    }

    private void init() {
        txt_assay_title.setText(mTextFile.getTitle());
        txt_assay_author.setText("作者：" + mTextFile.getAuthor() + "|" + "阅读量：" + mTextFile.getTimes());
        txt_assay_summary.setText(mTextFile.getSummary());
        txt_assay_text.setText(mTextFile.getText());
        txt_assay_authorbrief.setText(mTextFile.getAuthor());
        txt_assay_times.setText(mTextFile.getAuthorbrief());
    }


    @Override
    public void onTaskFinnished(byte[] data) {
        if (data != null) {
            try {
                JSONObject obj = new JSONObject(new String(data, "UTF-8"));
                mTextFile.parseJson(obj);
                init();
            } catch (JSONException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }
    }
}


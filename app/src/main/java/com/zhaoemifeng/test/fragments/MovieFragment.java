package com.zhaoemifeng.test.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhaoemifeng.myliabry.CommonFragmentAdapter;
import com.zhaoemifeng.myliabry.NetWorkTask;
import com.zhaoemifeng.myliabry.NetworkTaskCallback;
import com.zhaoemifeng.test.R;
import com.zhaoemifeng.test.fragments.homes.Movie1Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements NetworkTaskCallback {
    private ViewPager mViewPager;
    public MovieFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        mViewPager=(ViewPager)view.findViewById(R.id.movie_pager);
        NetWorkTask task=new NetWorkTask(getContext(),this);
        task.execute("http://api.shigeten.net/api/Critic/GetCriticList");
        return view ;
    }

    @Override
    public void onTaskFinnished(byte[] data) {
        System.out.println("onTaskFinished");
        List<Fragment> subFragments=new ArrayList<>();
        if (data != null) {
            try {
                String json= new String(data,"UTF-8");
                JSONObject jsonObject=new JSONObject(json);
                JSONArray array = jsonObject.getJSONArray("result");
                int len=array.length();
                for (int i = 0; i <len ; i++) {
                    JSONObject obj=array.getJSONObject(i);
                    String id=obj.getString("id");
                    Bundle bundle = new Bundle();
                    bundle.putString("movie1",id);
                    Movie1Fragment mfragment1=new Movie1Fragment();
                    mfragment1.setArguments(bundle);
                    Log.d("attrs--->", "onTaskFinished:解析id-" + id);
                    subFragments.add(mfragment1);
                }
                CommonFragmentAdapter adapter=new CommonFragmentAdapter(
                        getChildFragmentManager(),subFragments);
                mViewPager.setAdapter(adapter);
            } catch (UnsupportedEncodingException | JSONException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.zhaoemifeng.test.fragments.homes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zhaoemifeng.myliabry.NetWorkTask;
import com.zhaoemifeng.myliabry.NetworkTaskCallback;
import com.zhaoemifeng.test.R;
import com.zhaoemifeng.test.modle.TextMovie;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * implements NetworkTaskCallback
 * A simple {@link Fragment} subclass.
 */
public class Movie1Fragment extends Fragment implements NetworkTaskCallback {
    private TextMovie movie;
    private ImageView iv_movie11,iv_movie12,iv_movie13,iv_movie14,iv_movie15;
    private TextView txt_movie_times,txt_movie_title,txt_movie_text1,txt_movie_text2,txt_movie_text3,txt_movie_text4,txt_movie_text5,txt_movie_author,txt_movie_authorbrief;
    public Movie1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = new TextMovie();
        Bundle bund1 = getArguments();
        String id1=bund1.getString("movie1");
        //Log.d("test",id1);
        //TODO:加载网络
        NetWorkTask task=new NetWorkTask(getContext(),this);
        task.execute("http://api.shigeten.net/api/Critic/GetCriticContent?id="+id1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_movie1, container, false);
        iv_movie11= (ImageView) inflate.findViewById(R.id.iv_movie11);
        iv_movie12= (ImageView) inflate.findViewById(R.id.iv_movie12);
        iv_movie13= (ImageView) inflate.findViewById(R.id.iv_movie13);
        iv_movie14= (ImageView) inflate.findViewById(R.id.iv_movie14);
        iv_movie15= (ImageView) inflate.findViewById(R.id.iv_movie15);
        txt_movie_times=(TextView)inflate.findViewById(R.id.txt_movie1_times);
        txt_movie_title=(TextView)inflate.findViewById(R.id.txt_movie1_title);
        txt_movie_text1=(TextView)inflate.findViewById(R.id.txt_movie1_text1);
        txt_movie_text2=(TextView)inflate.findViewById(R.id.txt_movie1_text2);
        txt_movie_text3=(TextView)inflate.findViewById(R.id.txt_movie1_text3);
        txt_movie_text4=(TextView)inflate.findViewById(R.id.txt_movie1_text4);
        txt_movie_text5=(TextView)inflate.findViewById(R.id.txt_movie1_text5);
        txt_movie_author=(TextView)inflate.findViewById(R.id.txt_movie1_author);
        txt_movie_authorbrief=(TextView)inflate.findViewById(R.id.txt_movie1_authorbrief);
        init();
        return inflate;
    }
    private void init(){
        txt_movie_times.setText("作者："+movie.getAuthor()+"|阅读量："+movie.getTimes());
        txt_movie_title.setText(movie.getTitle());
        txt_movie_text1.setText(movie.getText1());
        txt_movie_text2.setText(movie.getText2());
        txt_movie_text3.setText(movie.getText3());
        txt_movie_text4.setText(movie.getText4());
        txt_movie_text5.setText(movie.getText5());
        txt_movie_author.setText(movie.getAuthor());
        txt_movie_authorbrief.setText(movie.getAuthorbrief());
        String image11 = movie.getImage1URL();
        if (image11 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image11).into(iv_movie11);
        }
        String image12 = movie.getImage2URL();
        if (image12 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image12).into(iv_movie12);
        }
        String image13 = movie.getImage3URL();
        if (image13 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image13).into(iv_movie13);
        }
        String image14 = movie.getImage4URL();
        if (image14 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image14).into(iv_movie14);
        }
        String image15 = movie.getImage5URL();
        if (image15 != null) {
            Picasso.with(getContext()).load("http://api.shigeten.net/"+image15).into(iv_movie15);
        }

    }

    @Override
    public void onTaskFinnished(byte[] data) {
        if (data != null) {
            try {
                JSONObject obj = new JSONObject(new String(data, "UTF-8"));
                movie.parseJson(obj);
                init();
            } catch (JSONException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }
    }
}

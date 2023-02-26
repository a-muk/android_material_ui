package com.example.materialui_trial;
import com.example.materialui_trial.Adapter.CommentsAdapter;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;

import android.widget.Toast;

import com.example.materialui_trial.Models.CommentModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;




public class VideosFragment extends Fragment {


    FloatingActionButton submit;
    ArrayList<CommentModel> arrComments = new ArrayList<>();
    CommentsAdapter adapter;
    RecyclerView recyclerView;
    Activity activity=getActivity();

    public VideosFragment() {
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view= inflater.inflate(R.layout.fragment_videos, container, false);
        RecyclerView commentsList=view.findViewById(R.id.commentList);
        commentsList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        EditText writeComment=(EditText) view.findViewById(R.id.writeComment);
        WifiManager wifiManager=(WifiManager) view.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String ipAddress= Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        submit=(FloatingActionButton) view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment="";
                String ip="From "+ipAddress;
                if(!writeComment.getText().toString().equals("")){
                    comment=writeComment.getText().toString();
                }else{
                    Toast.makeText(getContext(),"Please enter valid comment" ,Toast.LENGTH_SHORT).show();
                }
                arrComments.add(new CommentModel(ip,comment));
                adapter.notifyItemInserted(arrComments.size()-1);
                commentsList.scrollToPosition(arrComments.size()-1);
            }
        });

        adapter=new CommentsAdapter(getContext(),arrComments);
        commentsList.setAdapter(adapter);


        return view;
    }


}
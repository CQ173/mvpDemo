package com.example.myapplication.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;


public class TitleView extends RelativeLayout {

    // 返回按钮控件
    private Button mLeftBtn;
    // 标题Tv
    private TextView mTitleTv;

     public TitleView(Context context, AttributeSet attrs) {
         super(context, attrs);

         // 加载布局
         LayoutInflater.from(context).inflate(R.layout.title_bar, this);

         // 获取控件
         mLeftBtn = (Button) findViewById(R.id.left_btn);
         mTitleTv = (TextView) findViewById(R.id.title_tv);

     }

     // 为左侧返回按钮添加自定义点击事件
     public void setLeftButtonListener(OnClickListener listener) {
         mLeftBtn.setOnClickListener(listener);
     }

     // 设置标题的方法
     public void setTitleText(String title) {
         mTitleTv.setText(title);
     }
}

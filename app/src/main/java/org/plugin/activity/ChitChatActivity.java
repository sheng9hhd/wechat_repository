package org.plugin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.plugin.wechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘凡 on 2016/9/7.
 */
public class ChitChatActivity extends Activity implements View.OnClickListener {

    private TextView chitchat_title;
    private ImageView chitchat_more_add_img;
    private ViewPager viewPager;
    private boolean isvisible=false;
    private View view1, view2;
    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitchat);
        initView();
    }


    private void initView() {
        chitchat_title = (TextView) findViewById(R.id.chitchat_title);
        chitchat_title.setText(getIntent().getStringExtra("name"));
        chitchat_more_add_img = (ImageView) findViewById(R.id.chitchat_more_add_img);
        chitchat_more_add_img.setOnClickListener(this);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.activity_chitchat_viewpage1, null);
        view2 = inflater.inflate(R.layout.activity_chitchat_viewpage2,null);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View arg0 , Object arg1) {
                return arg0 == arg1;
            }
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chitchat_more_add_img:
                if(!isvisible){
                    isvisible=true;
                    viewPager.setVisibility(View.VISIBLE);
                }else {
                    isvisible=false;
                    viewPager.setVisibility(View.GONE);
                }
                break;
        }
    }
}

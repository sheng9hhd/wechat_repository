package org.plugin.wechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private Fragment[] fragments;
    public FragmentWeiXin weixinfragment;
    private FragmentFriends contactlistfragment;
    private FragmentFind findfragment;
    private FragmentMine minefragment;
    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private int index;
    private int currentTabIndex;
    private ImageView iv_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        iv_add = (ImageView) this.findViewById(R.id.iv_add);
        iv_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AddPopWindow addPopWindow = new AddPopWindow(MainActivity.this);
                addPopWindow.showPopupWindow(iv_add);
            }

        });

        weixinfragment = new FragmentWeiXin();
        contactlistfragment = new FragmentFriends();
        findfragment = new FragmentFind();
        minefragment = new FragmentMine();
        fragments = new Fragment[] { weixinfragment, contactlistfragment, findfragment, minefragment };
        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.ib_weixin);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_contact_list);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_find);
        imagebuttons[3] = (ImageView) findViewById(R.id.ib_mine);

        imagebuttons[0].setSelected(true);
        textviews = new TextView[4];
        textviews[0] = (TextView) findViewById(R.id.tv_weixin);
        textviews[1] = (TextView) findViewById(R.id.tv_contact_list);
        textviews[2] = (TextView) findViewById(R.id.tv_find);
        textviews[3] = (TextView) findViewById(R.id.tv_mine);
        textviews[0].setTextColor(0xFF45C01A);
        //
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, weixinfragment)
                .add(R.id.fragment_container, contactlistfragment).add(R.id.fragment_container, minefragment)
                .add(R.id.fragment_container, findfragment).hide(contactlistfragment).hide(minefragment)
                .hide(findfragment).show(weixinfragment).commit();

    }

    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.re_weixin:

                index = 0;
                break;
            case R.id.re_contact_list:

                index = 1;
                break;
            case R.id.re_find:

                index = 2;
                break;
            case R.id.re_mine:

                index = 3;
                break;

        }

        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);

        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;
    }

}

package org.plugin.wechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.plugin.adapter.WeiXinAdapter;
import org.plugin.entity.WeiXinEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cloudplug on 2016-09-07.
 */
public class FragmentWeiXin extends Fragment {

    private ListView listView;
    private WeiXinAdapter adapter;
    private List<WeiXinEntity> wxEntity;
    public RelativeLayout errorItem;
    public TextView errorText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initViews();

        initDatas();

        setViewListeners();

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    private void initViews() {

    }

    private void initDatas() {

        wxEntity = new ArrayList<WeiXinEntity>();
        WeiXinEntity item = null;
        for (int i = 0; i < 10; i++) {
            item = new WeiXinEntity();
            item.Name = "www";
            item.time = "2016-9-934";
            item.content = "444";
            item.icon = R.drawable.me_head;
            wxEntity.add(item);
        }

    }

    private void setViewListeners() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getView().findViewById(R.id.list);
        // if (savedInstanceState != null &&
        // savedInstanceState.getBoolean("isConflict", false))
        // return;

        adapter = new WeiXinAdapter(getActivity(), wxEntity, listView);

        listView.setAdapter(adapter);

    }

}

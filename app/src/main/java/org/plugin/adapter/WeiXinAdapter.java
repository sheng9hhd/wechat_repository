package org.plugin.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.plugin.entity.WeiXinEntity;
import org.plugin.wechat.R;

import java.util.List;

/**
 * Created by cloudplug on 2016-09-07.
 */
public class WeiXinAdapter extends BaseAdapter {
    private Context mContext;
    private List<WeiXinEntity> mList;
    private ListView lv;

    // private HashMap<String, Object> map;

    // private City2Entity[] cEntity;

    public WeiXinAdapter(FragmentActivity mContext, List<WeiXinEntity> wxEntity, ListView lv) {
        this.mContext = mContext;
        this.mList = wxEntity;
        this.lv = lv;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_weixin, null);
            holder = new ViewHolder();

            holder.Title = (TextView) convertView.findViewById(R.id.tv_name);
            holder.Time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.Content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.Icon = (ImageView) convertView.findViewById(R.id.iv_icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WeiXinEntity item = mList.get(position);
        holder.Title.setText(item.Name);
        holder.Time.setText(item.time);
        holder.Content.setText(item.content);
        holder.Icon.setBackgroundResource(item.icon);
        return convertView;
    }

    class ViewHolder {

        public TextView Title, Time, Content;
        public ImageView Icon;
        public RelativeLayout All;

    }

}
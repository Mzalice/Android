package com.example.administrator.gamehmg;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 用户列表Adapter
 * @author MzAlice 
 * @Time 2017.1.10
 */

public class UserAdapter extends BaseAdapter {

    private Context context;
    private List<Jhshuju> list;

    public UserAdapter(Context context, List<Jhshuju> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.simple, null);
        }
        // 得到一个ViewHolder
        viewHolder = ViewHolder.getViewHolder(convertView);
        viewHolder.image.setImageResource(list.get(position).getImage());
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.hp.setText(list.get(position).getHp());
        viewHolder.mp.setText(list.get(position).getMp());
        viewHolder.atk.setText(list.get(position).getAtk());
        viewHolder.def.setText(list.get(position).getDef());
        viewHolder.mat.setText(list.get(position).getMat());
        viewHolder.mdf.setText(list.get(position).getMdf());
        viewHolder.cri.setText(list.get(position).getCri());
        viewHolder.spd.setText(list.get(position).getSpd());
        viewHolder.luk.setText(list.get(position).getLuk());
        viewHolder.flee.setText(list.get(position).getFlee());

        return convertView;
    }

    private static class ViewHolder {

        TextView  name, hp, mp, atk, def, mat, mdf, cri, spd, luk, flee;
        ImageView image;

        private ViewHolder(View convertView) {
           image = (ImageView) convertView.findViewById(R.id.sim1);
           name = (TextView) convertView.findViewById(R.id.name);
           hp = (TextView) convertView.findViewById(R.id.hp);
           mp = (TextView) convertView.findViewById(R.id.mp);
           atk = (TextView) convertView.findViewById(R.id.atk);
           def = (TextView) convertView.findViewById(R.id.def);
           mat = (TextView) convertView.findViewById(R.id.mat);
           mdf = (TextView) convertView.findViewById(R.id.mdf);
           cri = (TextView) convertView.findViewById(R.id.cri);
           spd = (TextView) convertView.findViewById(R.id.spd);
           luk = (TextView) convertView.findViewById(R.id.luk);
           flee = (TextView) convertView.findViewById(R.id.flee);
        }

        // 得到一个ViewHolder
        public static ViewHolder getViewHolder(View convertView) {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }
    }
}
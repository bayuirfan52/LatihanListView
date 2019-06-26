package com.bayuirfan.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Hero> heroes;

    public HeroAdapter(Context context){
        this.context = context;
        heroes = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        ViewHolder holder = new ViewHolder(convertView);
        Hero hero = (Hero) getItem(position);
        holder.bind(hero);
        return convertView;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    class ViewHolder {
        private TextView txtName, txtDesc;
        private ImageView image;

        ViewHolder(View view){
            this.txtName = view.findViewById(R.id.name_list);
            this.txtDesc = view.findViewById(R.id.desc_list);
            this.image = view.findViewById(R.id.image_list);
        }

        void bind(Hero hero){
            txtName.setText(hero.getName());
            txtDesc.setText(hero.getDesc());
            image.setImageResource(hero.getPhoto());
        }
    }
}

package yashish.android.understandingmvp.repos.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yashish.android.understandingmvp.models.Repo;

public class ReposAdapter extends BaseAdapter {
    private List<Repo> list;
    private Context context;

    public ReposAdapter(Context context, List<Repo> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).id;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = ((Activity) context).getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        Repo repo = (Repo) getItem(position);
        holder.text1.setText(String.format("%s - %d", repo.name, repo.stars));
        return view;
    }

    public static class ViewHolder {
        @BindView(android.R.id.text1)
        TextView text1;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

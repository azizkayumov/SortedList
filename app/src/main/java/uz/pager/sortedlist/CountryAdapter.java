package uz.pager.sortedlist;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abduaziz on 9/1/17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    SortedList<Country> list;

    public CountryAdapter() {
        list = new SortedList<Country>(Country.class, new SortedList.Callback<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getCountry().compareTo(o2.getCountry());
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemRangeChanged(position, count);
            }

            @Override
            public boolean areContentsTheSame(Country oldItem, Country newItem) {
                return oldItem.getCountry().equals(newItem.getCountry());
            }

            @Override
            public boolean areItemsTheSame(Country item1, Country item2) {
                return item1.getCountry().equals(item2.getCountry());
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }
        });
    }

    //conversation helpers
    public void addAll(List<Country> countries) {
        list.beginBatchedUpdates();
        for (int i = 0; i < countries.size(); i++) {
            list.add(countries.get(i));
        }
        list.endBatchedUpdates();
    }

    public Country get(int position) {
        return list.get(position);
    }

    public void clear() {
        list.beginBatchedUpdates();
        //remove items at end, to avoid unnecessary array shifting
        while (list.size() > 0) {
            list.removeItemAt(list.size() - 1);
        }
        list.endBatchedUpdates();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = list.get(position);
        holder.textView.setText(country.getCountry());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_country);
        }

    }

}

package uk.co.onemandan.recyclerview.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uk.co.onemandan.recyclerview.R;
import uk.co.onemandan.recyclerview.ViewHolders.BaseViewHolder;
import uk.co.onemandan.recyclerview.ViewHolders.ViewHolderAddItem;
import uk.co.onemandan.recyclerview.ViewHolders.ViewHolderItem;

public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    //The data set, all items within the RecyclerView
    private List<Object> _recyclerViewItems;

    //Constructor to set the data set
    public RecyclerViewAdapter(List<Object> recyclerViewItems){
        _recyclerViewItems = recyclerViewItems;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == _recyclerViewItems.size() - 1) ? R.layout.row_item_add : R.layout.row_item;
    }

    //Inflate the RecyclerView view with the layout corresponding to the RecyclerViewItem
    //data class and the view type
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder = null;

        if(viewType == R.layout.row_item){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent,false);
            baseViewHolder = new ViewHolderItem(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_add, parent,false);
            baseViewHolder = new ViewHolderAddItem(view);
        }

        return baseViewHolder;
    }

    //Set the contents of the RecyclerView item
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(_recyclerViewItems.get(position));
    }

    //Return the size of the data set
    @Override
    public int getItemCount() {
        return _recyclerViewItems.size();
    }
}

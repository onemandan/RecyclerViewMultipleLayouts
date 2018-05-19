package uk.co.onemandan.recyclerview.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    BaseViewHolder(View view) {
        super(view);
    }

    public abstract void bind(T item);
}

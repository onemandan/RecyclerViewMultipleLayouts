package uk.co.onemandan.recyclerview.ViewHolders;

import android.view.View;
import android.widget.TextView;

import uk.co.onemandan.recyclerview.Classes.RecyclerViewItem;
import uk.co.onemandan.recyclerview.R;

public class ViewHolderItem extends BaseViewHolder<RecyclerViewItem> {

    private TextView Title, Subtitle;

    public ViewHolderItem(View view){
        super(view);

        Title = view.findViewById(R.id.tv_title);
        Subtitle = view.findViewById(R.id.tv_subtitle);
    }

    @Override
    public void bind(RecyclerViewItem item) {
        Title.setText(item.GetTitle());
        Subtitle.setText(item.GetSubtitle());
    }
}

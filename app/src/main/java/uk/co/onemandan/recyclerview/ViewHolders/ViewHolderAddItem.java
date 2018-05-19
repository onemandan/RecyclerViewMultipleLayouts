package uk.co.onemandan.recyclerview.ViewHolders;

import android.view.View;
import android.widget.TextView;

import uk.co.onemandan.recyclerview.R;

public class ViewHolderAddItem extends BaseViewHolder<String> {

    private TextView Title;

    public ViewHolderAddItem(View view){
        super(view);

        Title = view.findViewById(R.id.tv_title);
    }

    @Override
    public void bind(String item) {
        Title.setText(item);
    }
}

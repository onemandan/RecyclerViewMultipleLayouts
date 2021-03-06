package uk.co.onemandan.recyclerview.Activities;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import uk.co.onemandan.recyclerview.Adapters.RecyclerViewAdapter;
import uk.co.onemandan.recyclerview.Classes.RecyclerViewItem;
import uk.co.onemandan.recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView _recyclerView;
    private List<Object> _recyclerViewItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get RecyclerView handle
        _recyclerView   = findViewById(R.id.rv_list);

        //Save performance if you know the recycler view layout size is static
        _recyclerView.setHasFixedSize(true);

        //Set RecyclerView layout manager
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set RecyclerView adapter
        _recyclerView.setAdapter(new RecyclerViewAdapter(_recyclerViewItems));

        //Set Animator
        _recyclerView.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){

                    @Override
                    public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                        if (viewHolder.getItemViewType() == R.layout.row_item_add) return 0;
                        return super.getSwipeDirs(recyclerView, viewHolder);
                    }

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();

                        _recyclerViewItems.remove(position);
                        _recyclerView.getAdapter().notifyItemRemoved(position);
                    }

                    @Override
                    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
                        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                            float alpha = 1 - (Math.abs(dX) / recyclerView.getWidth());
                            viewHolder.itemView.setAlpha(alpha);
                        }
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(_recyclerView);

        _recyclerViewItems.add(getString(R.string.item_add));
        _recyclerViewItems.add(0, new RecyclerViewItem(getString(R.string.item_title), getString(R.string.item_subtitle)));
        _recyclerViewItems.add(0, new RecyclerViewItem(getString(R.string.item_title), getString(R.string.item_subtitle)));
        _recyclerViewItems.add(0, new RecyclerViewItem(getString(R.string.item_title), getString(R.string.item_subtitle)));
        _recyclerView.getAdapter().notifyDataSetChanged();
    }
}

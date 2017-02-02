package com.thedeveloperworldisyours.fullrecycleview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.DragGridFragment;
import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.DragAndSwipeListFragment;
import com.thedeveloperworldisyours.fullrecycleview.expandable.ExpandableFragment;
import com.thedeveloperworldisyours.fullrecycleview.horizontal.HorizontalFragment;
import com.thedeveloperworldisyours.fullrecycleview.multiple.MultipleFragment;
import com.thedeveloperworldisyours.fullrecycleview.swipe.SwipeListFragment;
import com.thedeveloperworldisyours.fullrecycleview.vertical.VerticalFragment;

public class MainActivity extends AppCompatActivity {
    Fragment mFragment;
    VerticalFragment mVerticalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mFragment = new DragAndSwipeListFragment();
            addFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_menu, menu);
        MenuItem addItem = menu.findItem(R.id.main_menu_add_item);

        if (mFragment instanceof VerticalFragment) {
            addItem.setVisible(true);
        } else {
            addItem.setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        invalidateOptionsMenu();

        switch (item.getItemId()) {
            case R.id.main_menu_list:
                mFragment = DragAndSwipeListFragment.newInstance();
                addFragment();
                return true;

            case R.id.main_menu_grid:
                mFragment = DragGridFragment.newInstance();
                addFragment();
                return true;

            case R.id.main_menu_swipe_list:
                mFragment = SwipeListFragment.newInstance();
                addFragment();
                return true;

            case R.id.main_menu_horizontal_list:
                mFragment = HorizontalFragment.newInstance();
                addFragment();
                return true;

            case R.id.main_menu_vertical_list:

                mFragment = VerticalFragment.newInstance();
                addFragment();
                mVerticalFragment = (VerticalFragment) mFragment;
                return true;

            case R.id.main_menu_expandable:
                mFragment = ExpandableFragment.newInstance();
                addFragment();
                return true;

            case  R.id.main_menu_add_item:
                mVerticalFragment.addItem();
                return true;

            case R.id.main_menu_multiple:
                mFragment = MultipleFragment.newInstance();
                addFragment();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addItemFromActivity() {

    }

    public void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mFragment)
                .addToBackStack(null)
                .commit();

    }

}
package com.thedeveloperworldisyours.fullrecycleview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.thedeveloperworldisyours.fullrecycleview.addfavorites.AddFavoritesFragment;
import com.thedeveloperworldisyours.fullrecycleview.animation.AnimationFragment;
import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.DragGridFragment;
import com.thedeveloperworldisyours.fullrecycleview.dragandswipe.DragAndSwipeListFragment;
import com.thedeveloperworldisyours.fullrecycleview.expandable.ExpandableFragment;
import com.thedeveloperworldisyours.fullrecycleview.horizontal.HorizontalFragment;
import com.thedeveloperworldisyours.fullrecycleview.indexed.IndexedFragment;
import com.thedeveloperworldisyours.fullrecycleview.multiple.MultipleFragment;
import com.thedeveloperworldisyours.fullrecycleview.sections.SectionFragment;
import com.thedeveloperworldisyours.fullrecycleview.sectionwithline.SectionWithLineFragment;
import com.thedeveloperworldisyours.fullrecycleview.single.SingleFragment;
import com.thedeveloperworldisyours.fullrecycleview.snap.SnapFragment;
import com.thedeveloperworldisyours.fullrecycleview.stickyheader.StickyHeaderFragment;
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
                break;

            case R.id.main_menu_grid:
                mFragment = DragGridFragment.newInstance();
                break;

            case R.id.main_menu_swipe_list:
                mFragment = SwipeListFragment.newInstance();
                break;

            case R.id.main_menu_horizontal_list:
                mFragment = HorizontalFragment.newInstance();
                break;

            case R.id.main_menu_vertical_list:
                mFragment = VerticalFragment.newInstance();
                break;

            case R.id.main_menu_expandable:
                mFragment = ExpandableFragment.newInstance();
                break;

            case R.id.main_menu_add_item:
                mVerticalFragment.addItem();
                break;

            case R.id.main_menu_multiple:
                mFragment = MultipleFragment.newInstance();
                break;
            case R.id.main_menu_single:
                mFragment = SingleFragment.newInstance();
                break;

            case R.id.main_menu_snap:
                mFragment = SnapFragment.newInstance();
                break;

            case R.id.main_menu_animation:
                mFragment = AnimationFragment.newInstance();
                break;

            case R.id.main_menu_section:
                mFragment = SectionFragment.newInstance();
                break;

            case R.id.main_menu_indexed:
                mFragment = IndexedFragment.newInstance();
                break;

            case R.id.main_menu_add_favorites:
                mFragment = AddFavoritesFragment.newInstance();
                break;

            case R.id.main_menu_section_with_line:
                mFragment = SectionWithLineFragment.newInstance();
                break;

            case R.id.main_menu_sticky_header:
                mFragment = StickyHeaderFragment.newInstance();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        addFragment();
        return true;
    }

    public void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mFragment)
                .addToBackStack(null)
                .commit();

    }

}
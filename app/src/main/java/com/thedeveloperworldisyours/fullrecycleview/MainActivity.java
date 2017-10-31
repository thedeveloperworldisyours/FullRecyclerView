package com.thedeveloperworldisyours.fullrecycleview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.thedeveloperworldisyours.fullrecycleview.addfavorites.AddFavoritesFragment;
import com.thedeveloperworldisyours.fullrecycleview.animation.AnimationFragment;
import com.thedeveloperworldisyours.fullrecycleview.chat.ChatFragment;
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
import com.thedeveloperworldisyours.fullrecycleview.updateData.UpdateDataFragment;
import com.thedeveloperworldisyours.fullrecycleview.vertical.VerticalFragment;

public class MainActivity extends AppCompatActivity {

    Fragment mFragment;
    VerticalFragment mVerticalFragment;
    UpdateDataFragment mUpdateDataFragment;

    private static final int MULTIPLE = 0;
    private static final int SINGLE = 1;
    private int mMode = 0;

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
        MenuItem mode = menu.findItem(R.id.main_menu_changes_mode);

        if (mFragment instanceof VerticalFragment) {
            addItem.setVisible(true);
        } else {
            addItem.setVisible(false);
        }

        if (mFragment instanceof UpdateDataFragment) {
            mode.setVisible(true);
        } else {
            mode.setVisible(false);
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
                mVerticalFragment = (VerticalFragment) mFragment;
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

            case R.id.main_menu_chat:
                mFragment = ChatFragment.newInstance();
                break;

            case R.id.main_menu_update_data:
                mFragment = UpdateDataFragment.newInstance();
                mUpdateDataFragment = (UpdateDataFragment) mFragment;
                break;
            case R.id.main_menu_changes_mode:
                updateMenuTitles();
            default:
                return super.onOptionsItemSelected(item);
        }

        addFragment();
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem mode = menu.findItem(R.id.main_menu_changes_mode);
        if (mMode == MULTIPLE) {
            mode.setTitle(getResources().getString(R.string.main_menu_update_data_single));
        } else {
            mode.setTitle(getResources().getString(R.string.main_menu_update_data_multiple));
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void updateMenuTitles() {
        invalidateOptionsMenu();
        if (mMode == MULTIPLE) {
            mMode = SINGLE;
        } else {
            mMode = MULTIPLE;
        }
        mUpdateDataFragment.changeMode(mMode);
    }

    public void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, mFragment)
                .disallowAddToBackStack()
                .commit();

    }

}
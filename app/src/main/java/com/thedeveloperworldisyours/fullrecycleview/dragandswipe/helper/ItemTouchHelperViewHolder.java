package com.thedeveloperworldisyours.fullrecycleview.dragandswipe.helper;

/**
 * Created by javierg on 12/10/2016.
 */

public interface ItemTouchHelperViewHolder {
    /**
     * Called when the itemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    void onItemSelected();


    /**
     * Called when the itemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    void onItemClear();
}

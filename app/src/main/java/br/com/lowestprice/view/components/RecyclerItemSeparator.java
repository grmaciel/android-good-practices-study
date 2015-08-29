package br.com.lowestprice.view.components;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Gilson Maciel on 29/08/2015.
 */
public class RecyclerItemSeparator extends RecyclerView.ItemDecoration {
    private final Drawable separator;

    public RecyclerItemSeparator(Drawable separator) {
        this.separator = separator;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 1; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            int top = v.getTop() + params.topMargin;
            int bottom = top + separator.getIntrinsicHeight();

            separator.setBounds(left, top, right, bottom);
            separator.draw(c);
        }
    }
}

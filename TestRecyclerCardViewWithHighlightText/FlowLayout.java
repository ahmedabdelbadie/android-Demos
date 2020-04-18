package eu.fiskur.chipcloud;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.crypto.Cipher;

import static android.content.ContentValues.TAG;

/**
 * @author RAW
 */
public class FlowLayout extends ViewGroup {

    private int line_height;
    Context context;
    int LINE2;
    int specPosition = -1;
    int xLastPos, yLastPos;
boolean EXPANDABLEFLAG = false ;
    public static class LayoutParams extends ViewGroup.LayoutParams {

        public final int horizontal_spacing;
        public final int vertical_spacing;

        /**
         * @param horizontal_spacing Pixels between items, horizontally
         * @param vertical_spacing   Pixels between items, vertically
         */
        public LayoutParams(int horizontal_spacing, int vertical_spacing) {
            super(0, 0);
            this.horizontal_spacing = horizontal_spacing;
            this.vertical_spacing = vertical_spacing;
        }
    }

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        assert (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED);
        final int width = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        int height = MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop() - getPaddingBottom();
        final int count = getChildCount();
        int line_height = 0;
        LINE2 = 0;
        int xpos = getPaddingLeft();
        int ypos = getPaddingTop();

        int childHeightMeasureSpec;
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        } else {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        final View childLast = getChildAt(count - 1);
        childLast.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST),
                childHeightMeasureSpec);
        final int childLastW = childLast.getMeasuredWidth();
        Log.i(TAG, "onMeasure: " + childLastW);
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST),
                        childHeightMeasureSpec);
                final int childw = child.getMeasuredWidth();
                line_height = Math.max(line_height, child.getMeasuredHeight() + lp.vertical_spacing);
                if (LINE2 == 1 && !EXPANDABLEFLAG) {
                    if (xpos + childw + childLastW > width) {
                        specPosition = i + 1;
                        xpos = childLastW + lp.horizontal_spacing;
                        xLastPos = xpos;
                        yLastPos = ypos;
                        break;
                    }
                } else {
                    if (xpos + childw > width) {
                        xpos = getPaddingLeft();
                        ypos += line_height;
                        Log.i(TAG, "onMeasure: Lines " + LINE2);
                        LINE2++;
                    }
                }
                xpos += childw + lp.horizontal_spacing;
            }
        }
        this.line_height = line_height;
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.UNSPECIFIED || (MeasureSpec.getMode(
                heightMeasureSpec) == MeasureSpec.AT_MOST && ypos + line_height < height)) {
            height = ypos + line_height;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(dpToPx(7), dpToPx(7));
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        final int width = r - l;
        int xpos = getPaddingLeft();
        int ypos = getPaddingTop();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final int childw = child.getMeasuredWidth();
                final int childh = child.getMeasuredHeight();
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (specPosition != -1 && specPosition - 1 == i && !EXPANDABLEFLAG ) break;
                else if (i==count-1)break;
                if (xpos + childw > width) {
                    xpos = getPaddingLeft();
                    ypos += line_height;
                }
                child.layout(xpos, ypos, xpos + childw, ypos + childh);
                xpos += childw + lp.horizontal_spacing;
            }
        }
        if (specPosition != -1 && !EXPANDABLEFLAG )
            getChildAt(count - 1).layout(xpos, ypos, xpos + getChildAt(count - 1).getMeasuredWidth(), ypos + getChildAt(count - 1).getMeasuredHeight());
        else removeViewAt(count-1);
    }
}


package eu.fiskur.chipcloud;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ChipCloud extends FlowLayout implements ChipListener {

    @Override
    public void chipClick(int index) {
        Toast.makeText(context, " Clicked " + index, Toast.LENGTH_SHORT).show();
        if (super.CANEXPANDABLE) {
            if (index == (super.getChildCount() - 1) && this.COLLAPSET) {
                this.COLLAPSET = false;
                super.removeAllViews();
                for (int i = 0; i < datas.size(); i++) {
                    addChip(datas.get(i));
                }
                invalidate();
            } else if (index == (super.getChildCount() - 1) && !this.COLLAPSET) {
                this.COLLAPSET = true;
                removeAllViews();
                for (int i = 0; i < datas.size(); i++) {
                    addChip(datas.get(i));
                }
                invalidate();
            }
        }
    }

    public void setSelectedChip(int index) {
        Chip chip = (Chip) getChildAt(index);
        for (int i = 0; i < getChildCount(); i++) {
            Chip chipp = (Chip) getChildAt(i);
            if (i == index) {
                chipp.setLocked(true);
            } else {
                chipp.setLocked(false);
            }
        }

    }

    private Context context;
    private int chipHeight;
    private int selectedColor = -1;
    private int selectedFontColor = -1;
    private int unselectedColor = -1;
    private int unselectedFontColor = -1;
    private int selectTransitionMS = 750;
    private int deselectTransitionMS = 500;

    public List<String> datas;

    public ChipCloud(Context context) {
        super(context);

        this.context = context;
        init();

    }

    public ChipCloud(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ChipCloud, 0, 0);
        int arrayReference = -1;
        try {
            selectedColor = a.getColor(R.styleable.ChipCloud_selectedColor, -1);
            selectedFontColor = a.getColor(R.styleable.ChipCloud_selectedFontColor, -1);
            unselectedColor = a.getColor(R.styleable.ChipCloud_deselectedColor, -1);
            unselectedFontColor = a.getColor(R.styleable.ChipCloud_deselectedFontColor, -1);
            selectTransitionMS = a.getInt(R.styleable.ChipCloud_selectTransitionMS, 750);
            deselectTransitionMS = a.getInt(R.styleable.ChipCloud_deselectTransitionMS, 500);
            int selectMode = a.getInt(R.styleable.ChipCloud_selectMode, 1);
        } finally {
            a.recycle();
        }
        datas = new ArrayList<>();
        init();

    }

    private void init() {
        chipHeight = (int) (28 * getResources().getDisplayMetrics().density + 0.5f);
    }

    public void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
    }

    public void setSelectedFontColor(int selectedFontColor) {
        this.selectedFontColor = selectedFontColor;
    }

    public void setUnselectedColor(int unselectedColor) {
        this.unselectedColor = unselectedColor;
    }

    public void setUnselectedFontColor(int unselectedFontColor) {
        this.unselectedFontColor = unselectedFontColor;
    }

    public void setSelectTransitionMS(int selectTransitionMS) {
        this.selectTransitionMS = selectTransitionMS;
    }

    public void setDeselectTransitionMS(int deselectTransitionMS) {
        this.deselectTransitionMS = deselectTransitionMS;
    }


    public void addALL(ArrayList<String> strings) {

        Log.i(TAG, "addALL: ");
        this.datas.addAll(strings);
        for (int i = 0; i < datas.size(); i++) {
            addChip(datas.get(i));
        }
        super.lastIndex = datas.size();
    }

    public void addChip(String label) {
        Chip chip = new Chip.ChipBuilder().index(getChildCount())
                .label(label)
                .selectedColor(selectedColor)
                .selectedFontColor(selectedFontColor)
                .unselectedColor(unselectedColor)
                .unselectedFontColor(unselectedFontColor)
                .selectTransitionMS(selectTransitionMS)
                .deselectTransitionMS(deselectTransitionMS)
                .chipHeight(chipHeight)
                .chipListener(this)
                .build(context);
        super.addView(chip);
    }

    //Apparently using the builder pattern to configure an object has been labelled a 'Bloch Builder'.
    public static class Configure {
        private ChipCloud chipCloud;
        private int selectedColor = -1;
        private int selectedFontColor = -1;
        private int deselectedColor = -1;
        private int deselectedFontColor = -1;
        private int selectTransitionMS = -1;
        private int deselectTransitionMS = -1;
        private String[] labels = null;
        private ChipListener chipListener;

        public Configure chipCloud(ChipCloud chipCloud) {
            this.chipCloud = chipCloud;
            return this;
        }


        public Configure selectedColor(int selectedColor) {
            this.selectedColor = selectedColor;
            return this;
        }

        public Configure selectedFontColor(int selectedFontColor) {
            this.selectedFontColor = selectedFontColor;
            return this;
        }

        public Configure deselectedColor(int deselectedColor) {
            this.deselectedColor = deselectedColor;
            return this;
        }

        public Configure deselectedFontColor(int deselectedFontColor) {
            this.deselectedFontColor = deselectedFontColor;
            return this;
        }

        public Configure selectTransitionMS(int selectTransitionMS) {
            this.selectTransitionMS = selectTransitionMS;
            return this;
        }

        public Configure deselectTransitionMS(int deselectTransitionMS) {
            this.deselectTransitionMS = deselectTransitionMS;
            return this;
        }

        public Configure labels(String[] labels) {
            this.labels = labels;
            return this;
        }

        public Configure chipListener(ChipListener chipListener) {
            this.chipListener = chipListener;
            return this;
        }

        public void build() {
            if (selectedColor != -1) chipCloud.setSelectedColor(selectedColor);
            if (selectedFontColor != -1) chipCloud.setSelectedFontColor(selectedFontColor);
            if (deselectedColor != -1) chipCloud.setUnselectedColor(deselectedColor);
            if (deselectedFontColor != -1) chipCloud.setUnselectedFontColor(deselectedFontColor);
            if (selectTransitionMS != -1) chipCloud.setSelectTransitionMS(selectTransitionMS);
            if (deselectTransitionMS != -1) chipCloud.setDeselectTransitionMS(deselectTransitionMS);
        }
    }
}

package com.example.ahmed.navimanually;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment /*implements AdapterIcon.parse*/ {
    private boolean mUserLearned, mFromSavePref;
    private static final String KEY_USER_LEARNED = "key_user_learned";
    private static final String FILE_NAME = "savePref";
    private static final String TAG = "BLANK";
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private RecyclerView mRecyclerView;
    private View containerView;
    AdapterIcon adapterIcon;


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapterIcon = new AdapterIcon(getContext());
        /*adapterIcon.setParse(this);*/
        mUserLearned = Boolean.valueOf(getFromPref(getActivity(), KEY_USER_LEARNED, "false"));
        if (savedInstanceState != null) {
            mFromSavePref = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_blank, container, false);
        Log.d(TAG, "onCreateView: 1 ");
        mRecyclerView = layout.findViewById(R.id.rv_item);
        Log.d(TAG, "onCreateView: 2 ");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d(TAG, "onCreateView: 3");
        mRecyclerView.setAdapter(adapterIcon);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewListner(getActivity(), mRecyclerView, new ClickListner() {
            @Override
            public void onClick(View v, int p) {
                Log.i("intecept", "onClick: "+p);
                Toast.makeText(getActivity(), "onClick: "+p, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View v, int p) {
                Log.i("intecept", "onLongClick: "+p);
                Toast.makeText(getActivity(), "onLongClick: "+p, Toast.LENGTH_SHORT).show();
            }
        }));
        Log.d(TAG, "onCreateView: 4");
        return layout;
    }

    public void setup(int blank_frag, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(blank_frag);
        mDrawerLayout = drawerLayout;
        mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearned) {
                    mUserLearned = true;
                    saveToPref(getActivity(), KEY_USER_LEARNED, mUserLearned + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset < 0.6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };
        if (!mUserLearned && !mFromSavePref) {
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPref(Context c, String k, String v) {
        SharedPreferences preferences = c.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(k, v);
        editor.apply();
    }

    public static String getFromPref(Context c, String k, String d) {
        SharedPreferences preferences = c.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(k, d);
    }

    public class RecyclerViewListner implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        ClickListner clickListner;

        public RecyclerViewListner(final Context c, final RecyclerView r,final ClickListner cl) {
            this.clickListner = cl;
            gestureDetector = new GestureDetector(c, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Log.w("intercept", "onSingleTapUp: " + e);
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = r.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListner != null) {
                        clickListner.onLongClick(child, r.getChildLayoutPosition(child));
                    }

                }
            });
            Log.w("intercept", "RecyclerViewListner: ");
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
/*            switch (e.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    Log.w("intercept", "onInterceptTouchEvent: d " + e);
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.w("intercept", "onInterceptTouchEvent: m " + e);
                    break;
                case MotionEvent.ACTION_UP:
                    Log.w("intercept", "onInterceptTouchEvent: u " + e);
                    break;
            }*/
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListner!=null && gestureDetector != null) {
                clickListner.onClick(child, rv.getChildLayoutPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.w("intercept", "onTouchEvent: " + e);
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public static interface ClickListner {
        public void onClick(View v, int p);
        public void onLongClick(View v, int p);
    }

    /*@Override
    public void parsePosition(View v, int p) {
        Toast.makeText(getActivity(), "choice "+p, Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawer(containerView);
    }*/
}

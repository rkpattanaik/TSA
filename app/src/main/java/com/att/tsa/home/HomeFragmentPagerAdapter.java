package com.att.tsa.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.att.tsa.R;
import com.att.tsa.home.dashboard.DashboardFragment;
import com.att.tsa.home.geolocator.GeolocatorFragment;
import com.att.tsa.home.reports.ReportsFragment;


/**
 * @author Rajesh Pattanaik
 */

class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Dashboard", "Geolocator", "Reports" };
    private int[] icons = {
            R.drawable.ic_dashboard_white_24dp,
            R.drawable.ic_place_white_24dp,
            R.drawable.ic_reports_white_24dp
    };
    private Context context;

    HomeFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = DashboardFragment.newInstance();
                break;
            case 1:
                fragment = GeolocatorFragment.newInstance();
                break;
            case 2:
                fragment = ReportsFragment.newInstance();
                break;
            default:
                fragment = DashboardFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    /*@Override
    public CharSequence getPageTitle(int position) {
        Drawable image = ContextCompat.getDrawable(context, icons[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString("   " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }*/

    View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivTabIcon);
        TextView textView = (TextView) view.findViewById(R.id.tvTabText);
        imageView.setImageResource(icons[position]);
        textView.setText(tabTitles[position]);
        return view;
    }
}

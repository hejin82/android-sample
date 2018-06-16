package org.hejin.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsContentFragment extends Fragment {

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main, parent, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}

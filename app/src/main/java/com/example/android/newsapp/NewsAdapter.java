package com.example.android.newsapp;

/**
 * Created by Eli on 23-Jul-18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


/**
 * A {@link NewsAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news/articles, which is the data source of the adapter
     */
    public  NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of news
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news item at the given position in the list of News
        News currentNews = getItem(position);

        // Find the TextView with view ID title
        TextView articleTitleView = (TextView) listItemView.findViewById(R.id.title);
        articleTitleView.setText(currentNews.getWebTitle());

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSectionName());


        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.publication_date);

        // Display the date of the current news item in that TextView
        String publicationDate =  currentNews.getWebPublicationDate();
        if ( publicationDate == null || publicationDate.length() == 0) {
            dateView.setVisibility(View.GONE);
        } else{
            dateView.setText(publicationDate);
            dateView.setVisibility(View.VISIBLE);
        }

        // Find the TextView with view ID contributors
        TextView contributorsView = (TextView) listItemView.findViewById(R.id.contributors);

        String contributors = formatContributors(currentNews.getContributors());

        if ( contributors.length() == 0) {
            contributorsView.setVisibility(View.GONE);
        } else {
            contributorsView.setText(contributors);
            contributorsView.setVisibility(View.VISIBLE);
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


    //https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
    private String formatContributors(ArrayList<String> contributors){

        int contributorsNumber = contributors.size();

        if (contributorsNumber < 1){
            return "";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int currentContributorId = 1;

            sb.append("By ");

            for (String s : contributors)
            {
                sb.append(s);

                if (currentContributorId < contributorsNumber){
                    sb.append(", ");
                    currentContributorId++;
                }
            }

            return sb.toString();
        }
    }

}

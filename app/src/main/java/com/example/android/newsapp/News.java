package com.example.android.newsapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Eli on 23-Jul-18.
 */

public class News {

    /** Section name of the news entry */
    private String nSectionName;

    /** Title of the news entry */
    private String nWebTitle;

    /** Url of the news entry */
    private String nUrl;

    /** Publication date of the news entry in milliseconds*/
    private String nWebPublicationDate;

    /** List of contributors of the news entry **/
    private ArrayList<String> nContributors;

    /**
     * Constructs a new {@link News} object.
     *
     * @param sectionName is the Section name of the news entry
     * @param webTitle is the Title of the news entry
     * @param url is the Url of the news entry
     * @param webPublicationDate is the Publication date of the news entry in Javascript format
     * @param contributors is the list of contributors of the news entry
     */
    public News(String sectionName, String webTitle, String url, String webPublicationDate, ArrayList<String> contributors) {
        nSectionName = sectionName;
        nWebTitle = webTitle;
        nUrl = url;
        nWebPublicationDate = webPublicationDate;
        nContributors = contributors;
    }

    /**
     * Returns the section name of the news entry
     */
    public String getSectionName(){ return nSectionName; }

    /**
     * Returns the Title of the news entry
     */
    public String getWebTitle(){ return nWebTitle; }

    /**
     * Returns the Url of the news entry
     */
    public String getUrl(){ return nUrl; }

    /**
     * Returns the Publication date of the news entry in milliseconds
     */
    public String getWebPublicationDate(){ return nWebPublicationDate; }

    /**
     * Returns the Contributors (authors) of the news entry
     */
    public ArrayList<String> getContributors(){ return nContributors; }

}

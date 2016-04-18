package com.mvp.net;

/**
 * Created by cfp on 16-4-18.
 */
public class GithubUrl {


    private String current_user_url;
    private String current_user_authorizations_html_url;
    private String authorizations_url;

    @Override
    public String toString() {
        return "GithubUrl{" +
                "current_user_url='" + current_user_url + '\'' +
                ", current_user_authorizations_html_url='" + current_user_authorizations_html_url + '\'' +
                ", authorizations_url='" + authorizations_url + '\'' +
                '}';
    }
}

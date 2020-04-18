package com.androidtutorialpoint.retrofittest;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ahmed on 12/8/2017.
 */

public class MovieModel implements Parcelable {

    private String poster_path;
    private String adult;
    private String overview;
    private String release_date;
    private String id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private String popularity;
    private String vote_average;
    private String video;
    private String vote_count;

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOriginalTitle(String original_title) {
        this.original_title = original_title;
    }

    public void setOriginalLang(String original_language) {
        this.original_language = original_language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackdrop(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public void setVoteCount(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setVoteRange(String vote_count) {
        this.vote_count = vote_count;
    }

    public MovieModel(String poster_path,
                      String adult,
                      String overview,
                      String release_date,
                      String id,
                      String original_title,
                      String original_language,
                      String title,
                      String backdrop_path,
                      String popularity,
                      String vote_average,
                      String video,
                      String vote_count) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.video = video;
        this.vote_count = vote_count;
    }

    protected MovieModel(Parcel in) {
        poster_path = in.readString();
        adult = in.readString();
        overview = in.readString();
        release_date = in.readString();
        id = in.readString();
        original_title = in.readString();
        original_language = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        popularity = in.readString();
        vote_average = in.readString();
        video = in.readString();
        vote_count = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getPosterPath() {
        return poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public String getId() {
        return id;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public String getOriginalLang() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop() {
        return backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getVoteCount() {
        return vote_average;
    }

    public String getVideo() {
        return video;
    }

    public String getVoteRange() {
        return vote_count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(poster_path);
        parcel.writeString(adult);
        parcel.writeString(overview);
        parcel.writeString(release_date);
        parcel.writeString(id);
        parcel.writeString(original_title);
        parcel.writeString(original_language);
        parcel.writeString(title);
        parcel.writeString(backdrop_path);
        parcel.writeString(popularity);
        parcel.writeString(vote_average);
        parcel.writeString(video);
        parcel.writeString(vote_count);

    }

}

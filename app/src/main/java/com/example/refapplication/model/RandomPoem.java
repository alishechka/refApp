package com.example.refapplication.model;

import com.example.refapplication.dao.StringListConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

@Entity(tableName = "random_poem_table")
public class RandomPoem {
    @PrimaryKey
    @SerializedName("title")
    @Expose
    @NonNull
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("lines")
    @Expose
    @TypeConverters(StringListConverter.class)
    private List<String> lines = null;
    @SerializedName("linecount")
    @Expose
    @Ignore
    private String linecount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getLinecount() {
        return linecount;
    }

    public void setLinecount(String linecount) {
        this.linecount = linecount;
    }

    @Override
    public String toString() {
        return "RandomPoem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", lines=" + lines +
                ", linecount='" + linecount + '\'' +
                '}';
    }
}

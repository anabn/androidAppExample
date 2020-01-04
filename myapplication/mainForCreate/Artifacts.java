package com.myapplication.mainForCreate;

import java.util.regex.Pattern;

/**
 * Artifacts - бд
 * @see CreateActivity
 *
 *
 */
public class Artifacts {

    String nameIdOfTittle;
    String nameOfTittle;
    String nameOfAuthor;
    int checkedStatus;
    String allPages;
    String currentPage;

    private  static final Pattern L_PATTERN = Pattern.compile("\\d+?");

    public Artifacts(){
    }

    public Artifacts(String nameIdOfTittle, String nameOfTittle,
                     String nameOfAuthor, int checkedStatus) {
        this.nameIdOfTittle = nameIdOfTittle;
        this.nameOfTittle = nameOfTittle;
        this.nameOfAuthor = nameOfAuthor;
        this.checkedStatus = checkedStatus;
    }


    public Artifacts(String nameIdOfTittle, String nameOfTittle,
                     String nameOfAuthor, int checkedStatus, String currentPage, String allPages) {
        this.nameIdOfTittle = nameIdOfTittle;
        this.nameOfTittle = nameOfTittle;
        this.nameOfAuthor = nameOfAuthor;
        this.checkedStatus = checkedStatus;
        this.currentPage = currentPage;
        this.allPages = allPages;
    }

    public String getNameIdOfTittle() {
        return nameIdOfTittle;
    }

    public String getNameOfTittle() {
        return nameOfTittle;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public int getCheckedStatus() {
        return checkedStatus;
    }

    public String getAllPages() {
        return allPages;
    }

    public String getCurrentPage() {
        return currentPage;
    }

}

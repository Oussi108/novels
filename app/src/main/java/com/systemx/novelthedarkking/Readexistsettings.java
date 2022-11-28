package com.systemx.novelthedarkking;

public class Readexistsettings {
    private String colorch;
    private int fontsize;


    public Readexistsettings(String colorch, int fontsize) {
        this.colorch = colorch;
        this.fontsize = fontsize;
    }

    public boolean getcolor(){

        if(colorch == "white"){
            return false;
        }
        else {return true;}

    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    public void setColorch(String colorch) {
        this.colorch = colorch;
    }

    public int getFontsize() {
        return fontsize;
    }

}

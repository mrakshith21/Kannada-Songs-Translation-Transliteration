package org.rakshith.songvideowithtranslation.model;

public class TextResponse {

    String text;

    public TextResponse(){
    }

    public TextResponse(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

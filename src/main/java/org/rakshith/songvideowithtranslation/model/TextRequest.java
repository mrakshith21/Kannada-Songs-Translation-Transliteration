package org.rakshith.songvideowithtranslation.model;

public class TextRequest {

    private String s;
    private String source;
    private String target;

    public TextRequest(String s, String source, String target) {
        this.s = s;
        this.source = source;
        this.target = target;
    }

    public TextRequest() {
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString(){
        return s + "\n" + source + "\n" + target;
    }
}

package io.turntabl.Polls.models;

public class OptionTO {
    private int options_id;
    private int poll_id;
    private String content;

    public OptionTO() {
    }

    public OptionTO(int option_id, int poll_id, String content) {
        this.options_id = option_id;
        this.poll_id = poll_id;
        this.content = content;
    }

    public int getOptions_id() {
        return options_id;
    }

    public void setOptions_id(int options_id) {
        this.options_id = options_id;
    }

    public int getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(int poll_id) {
        this.poll_id = poll_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "OptionTO{" +
                "option_id=" + options_id +
                ", poll_id=" + poll_id +
                ", content=" + content +
                '}';
    }
}

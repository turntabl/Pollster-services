package io.turntabl.Polls.models;

public class OptionTO {
    private String option_id;
    private String poll_id;
    private String content;

    public OptionTO() {
    }

    public OptionTO(String option_id, String poll_id, String content) {
        this.option_id = option_id;
        this.poll_id = poll_id;
        this.content = content;
    }

    public String getOption_id() { return option_id; }

    public void setOption_id(String option_id) { this.option_id = option_id; }

    public String getPoll_id() { return poll_id; }

    public void setPoll_id(String poll_id) { this.poll_id = poll_id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "OptionTO{" +
                "option_id=" + option_id +
                ", poll_id=" + poll_id +
                ", content=" + content +
                '}';
    }
}

package io.turntabl.Polls.models;

import java.util.ArrayList;
import java.util.List;

public class OptionTO {
    private String options_id;
    private String poll_id;
    private String content;

    public OptionTO() {
    }

    public OptionTO(String options_id, String poll_id, String content) {
        this.options_id = options_id;
        this.poll_id = poll_id;
        this.content = content;
    }

    public String getOptions_id() { return options_id; }

    public void setOptions_id(String options_id) { this.options_id = options_id; }

    public String getPoll_id() { return poll_id; }

    public void setPoll_id(String poll_id) { this.poll_id = poll_id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "OptionTO{" +
                "option_id=" + options_id +
                ", poll_id=" + poll_id +
                ", content=" + content +
                '}';
    }
}

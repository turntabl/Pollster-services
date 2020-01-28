package io.turntabl.Polls.models;

import java.util.List;

public class PollTO {
    private String poll_id;
    private String creator_id;
    private String question;
    private String creator_email;
    private String recipient_email;
    private List<OptionTO> options;

    public PollTO() {
    }

    public PollTO(String poll_id, String creator_id, String question, String creator_email, String recipient_email, List<OptionTO> options) {
        this.poll_id = poll_id;
        this.creator_id = creator_id;
        this.question = question;
        this.creator_email = creator_email;
        this.recipient_email = recipient_email;
        this.options = options;
    }

    public String getPoll_id() { return poll_id; }

    public void setPoll_id(String poll_id) { this.poll_id = poll_id; }

    public String getCreator_id() { return creator_id; }

    public void setCreator_id(String creator_id) { this.creator_id = creator_id; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public String getCreator_email() { return creator_email; }

    public void setCreator_email(String creator_email) { this.creator_email = creator_email; }

    public String getRecipient_email() { return recipient_email; }

    public void setRecipient_email(String recipient_email) {
        this.recipient_email = recipient_email;
    }

    public List<OptionTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionTO> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "PollTO{" +
                "poll_id='" + poll_id + '\'' +
                ", creator_id='" + creator_id + '\'' +
                ", question='" + question + '\'' +
                ", creator_email='" + creator_email + '\'' +
                ", recipient_email='" + recipient_email + '\'' +
                ", options=" + options +
                '}';
    }
}

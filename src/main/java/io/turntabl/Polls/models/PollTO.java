package io.turntabl.Polls.models;

public class PollTO {
    private String poll_id;
    private String creator_id;
    private String question;

    public PollTO() {
    }

    public PollTO(String poll_id, String creator_id, String question) {
        this.poll_id = poll_id;
        this.creator_id = creator_id;
        this.question = question;
    }

    public String getPoll_id() { return poll_id; }

    public void setPoll_id(String poll_id) { this.poll_id = poll_id; }

    public String getCreator_id() { return creator_id; }

    public void setCreator_id(String creator_id) { this.creator_id = creator_id; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    @Override
    public String toString() {
        return "PollTO{" +
                "poll_id=" + poll_id +
                ", creator_id=" + creator_id +
                ", questions='" + question + '\'' +
                '}';
    }
}

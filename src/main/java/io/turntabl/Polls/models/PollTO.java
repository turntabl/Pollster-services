package io.turntabl.Polls.models;

public class PollTO {
    private String poll_id;
    private String creator_id;
    private String questions;

    public PollTO() {
    }

    public PollTO(String poll_id, String creator_id, String questions) {
        this.poll_id = poll_id;
        this.creator_id = creator_id;
        this.questions = questions;
    }

    public String getPoll_id() { return poll_id; }

    public void setPoll_id(String poll_id) { this.poll_id = poll_id; }

    public String getCreator_id() { return creator_id; }

    public void setCreator_id(String creator_id) { this.creator_id = creator_id; }

    public String getQuestions() { return questions; }

    public void setQuestions(String questions) { this.questions = questions; }

    @Override
    public String toString() {
        return "PollTO{" +
                "poll_id=" + poll_id +
                ", creator_id=" + creator_id +
                ", questions='" + questions + '\'' +
                '}';
    }
}

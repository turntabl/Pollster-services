package io.turntabl.Polls.models;

public class ResponseTO {
    private String response_id;
    private String option_id;
    private String poll_id;

    public ResponseTO() {
    }

    public ResponseTO(String response_id, String option_id, String poll_id) {
        this.response_id = response_id;
        this.option_id = option_id;
        this.poll_id = poll_id;
    }

    public String getResponse_id() {
        return response_id;
    }

    public void setResponse_id(String response_id) {
        this.response_id = response_id;
    }

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    public String getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(String poll_id) {
        this.poll_id = poll_id;
    }

    @Override
    public String toString() {
        return (
                "ResponseTO{" +
                        "response_id='" +
                        response_id +
                        '\'' +
                        ", option_id='" +
                        option_id +
                        '\'' +
                        ", poll_id='" +
                        poll_id +
                        '\'' +
                        '}'
        );
    }
}

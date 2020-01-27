package io.turntabl.Polls.models;

public class ResponseTO {
    private String response_id;
    private String options_id;
    private String suggestions;

    public ResponseTO() {
    }

    public ResponseTO(String response_id, String options_id, String suggestions) {
        this.response_id = response_id;
        this.options_id = options_id;
        this.suggestions = suggestions;
    }

    public String getResponse_id() { return response_id; }

    public void setResponse_id(String response_id) { this.response_id = response_id; }

    public String getOptions_id() { return options_id; }

    public void setOptions_id(String options_id) { this.options_id = options_id; }

    public String getSuggestions() { return suggestions; }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "ResponseTO{" +
                "response_id=" + response_id +
                ", options_id=" + options_id +
                ", suggestions='" + suggestions + '\'' +
                '}';
    }
}

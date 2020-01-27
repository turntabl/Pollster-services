package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.PollTO;;

import java.util.List;

public interface PollDAO {
    public void addNewPoll(PollTO poll);
    public void deletePoll(String id);
    public List<PollTO> viewAllPolls();
    public PollTO viewPollById(String id);
}

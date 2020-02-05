package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.PollTO;
import java.util.List;

public interface PollDAO {
    public void addNewPoll2(PollTO poll);
    public List<PollTO> viewAllPolls();
    public PollTO viewPollById(String id);
}

package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.OptionTO;
import io.turntabl.Polls.models.PollTO;
import io.turntabl.Polls.models.ResponseTO;
import io.turntabl.Polls.models.UserTO;

import java.util.List;

public interface DAO {

    public void addNewOptions(OptionTO option);
    public List<OptionTO> getAllOptions();
    public OptionTO getOptionById(String id);
    public List<OptionTO> getOptionsByPollsId(String id);

    public void addNewPoll(PollTO poll);
    public List<PollTO> viewAllPolls();
    public PollTO viewPollById(String id);


    public void addNewResponse(ResponseTO poll);
    public void deleteResponse(String id);
    public List<ResponseTO> viewAllResponse();
    public ResponseTO viewResponseById(String id);
    public List<ResponseTO> getResponsesByPollsId(String id);



    public void addNewPoll2(PollTO poll);


}

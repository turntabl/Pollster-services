package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.OptionTO;
import io.turntabl.Polls.models.ResponseTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ResponseDAO {
    public void addNewResponse(ResponseTO poll);
    public void deleteResponse(String id);
    public List<ResponseTO> viewAllResponse();
    public ResponseTO viewResponseById(String id);
    public List<ResponseTO> getResponsesByPollsId(String id);
}


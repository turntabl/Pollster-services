package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.ResponseTO;

import java.util.List;

public interface ResponseDAO {
    public void addNewResponse(ResponseTO poll);
    public List<ResponseTO> viewAllResponse();
    public ResponseTO viewResponseById(String id);
    public List<ResponseTO> getResponsesByPollsId(String id);
}

package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.ResponseTO;

import java.util.List;

public interface ResponseDAO {
    public void addNewResponse(ResponseTO poll);
    public void deleteResponse(String id);
    public List<ResponseTO> viewAllResponse();
    public ResponseTO viewResponseById(String id);
}


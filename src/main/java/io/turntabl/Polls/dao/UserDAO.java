package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.UserTO;

import java.util.List;

public interface UserDAO {
    public List<UserTO> getAllCreators();
    public void AddNewCreator(UserTO creator);
    public UserTO getCreatorById(String id);
    public void deleteCreator(String id);
}

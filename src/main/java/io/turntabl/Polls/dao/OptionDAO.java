package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.OptionTO;

import java.util.List;

public interface OptionDAO {
    public void addNewOptions(OptionTO option);
    public List<OptionTO> getAllOptions();
    public OptionTO getOptionById(String id);
    public List<OptionTO> getOptionsByPollsId(String id);
}

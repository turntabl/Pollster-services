package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.OptionTO;

import java.util.List;

public interface OptionsDAO {
    public void addNewOptions(OptionTO option);
    public List<OptionTO> getAllOptions();
    public void deleteOption(Integer id);
    public OptionTO getOptionById(Integer id);
}

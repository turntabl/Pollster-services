package io.turntabl.Polls.dao;

import io.turntabl.Polls.models.OptionTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OptionsDAO {
    public void addNewOptions(OptionTO option);
    public List<OptionTO> getAllOptions();
    public void deleteOption(Integer id);
    public OptionTO getOptionById(Integer id);
    public List<OptionTO> getOptionsByPollsId(Integer id);
}

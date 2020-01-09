package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.dao.OptionsDAO;
import io.turntabl.Polls.models.OptionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class OptionController implements OptionsDAO {

    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add an Option")
    @Override
    @PostMapping("/api/v1/options")
    public void addNewOptions(@RequestBody OptionTO option) {
        template.update("insert into options (options_id, poll_id, content) values(?,?,?)", option.getOptions_id(), option.getPoll_id(), option.getContent());

    }

    @CrossOrigin
    @ApiOperation("Get all Options")
    @Override
    @GetMapping("/api/v1/options")
    public List<OptionTO> getAllOptions() {
        return this.template.query("select * from options", new BeanPropertyRowMapper<OptionTO>(OptionTO.class));
    }

    @CrossOrigin
    @ApiOperation("Delete an Option")
    @Override
    @DeleteMapping("/api/v1/options/{id}")
    public void deleteOption(@PathVariable("id") Integer id) {
        template.update("delete from options where options_id = ?", id);
    }

    @CrossOrigin
    @ApiOperation("Get an Option by ID")
    @Override
    @GetMapping("/api/v1/options/{id}")
    public OptionTO getOptionById(@PathVariable("id") Integer id) {
        return (OptionTO) template.queryForObject("select * from options where options_id = ?", new Object[]{id},
                new BeanPropertyRowMapper(OptionTO.class));
    }
}

package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.dao.PollDAO;
import io.turntabl.Polls.models.PollTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class PollController implements PollDAO {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Poll")
    @Override
    @PostMapping("/api/v1/polls")
    public void addNewPoll(@RequestBody PollTO poll) {
        template.update("insert into polls(creator_id, questions) values (?,?)", poll.getCreator_id(), poll.getQuestions());
    }

    @CrossOrigin
    @ApiOperation("Get all Polls")
    @Override
    @GetMapping("/api/v1/polls")
    public List<PollTO> viewAllPolls() {
        return this.template.query("select * from polls", new BeanPropertyRowMapper<PollTO>(PollTO.class));
    }

    @CrossOrigin
    @ApiOperation("Delete a Poll")
    @Override
    @DeleteMapping("/api/v1/polls/{id}")
    public void deletePoll(@PathVariable("id") String id) {
        template.update("delete from polls where poll_id = ?", id);
    }

    @CrossOrigin
    @ApiOperation("Get Poll by ID")
    @Override
    @GetMapping("/api/v1/polls/{id}")
    public PollTO viewPollById(@PathVariable("id") String id) {
        return (PollTO) template.queryForObject("select * from polls where poll_id = ?", new Object[]{id},
                new BeanPropertyRowMapper(PollTO.class));
    }
}

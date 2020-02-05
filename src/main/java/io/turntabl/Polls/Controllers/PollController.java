package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.models.OptionTO;
import io.turntabl.Polls.models.PollTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class PollController {
  @Autowired
  JdbcTemplate template;

  @CrossOrigin
  @PostMapping("/api/v1/addNewPoll2")
  public void addNewPoll2(@RequestBody PollTO poll) {
    template.update(
            "insert into polls(poll_id, question, creator_email, recipient_email) values(?,?,?,?)",
            poll.getPoll_id(),
            poll.getQuestion(),
            poll.getCreator_email(),
            poll.getRecipient_email()
    );
    for (OptionTO o : poll.getOptions()) {
      template.update(
              "insert into options(option_id, poll_id, content) values(?,?,?)",
              o.getOption_id(),
              o.getPoll_id(),
              o.getContent()
      );
    }
  }

  @CrossOrigin
  @ApiOperation("Get all Polls")
  @GetMapping("/api/v1/polls")
  public List<PollTO> viewAllPolls() {
    return this.template.query(
            "select * from polls",
            new BeanPropertyRowMapper<PollTO>(PollTO.class)
    );
  }

  @CrossOrigin
  @ApiOperation("Get Poll by ID")
  @GetMapping("/api/v1/polls/{id}")
  public PollTO viewPollById(@PathVariable("id") String id) {
    return (PollTO) template.queryForObject(
            "select * from polls where poll_id = ?",
            new Object[]{id},
            new BeanPropertyRowMapper(PollTO.class)
    );
  }
}







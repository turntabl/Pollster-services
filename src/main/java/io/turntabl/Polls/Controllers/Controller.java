package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.dao.DAO;
import io.turntabl.Polls.models.OptionTO;
import io.turntabl.Polls.models.PollTO;
import io.turntabl.Polls.models.ResponseTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class Controller implements DAO {
  @Autowired
  JdbcTemplate template;

  // Polls Controller

  @CrossOrigin
  @ApiOperation("Add a Poll")
  @Override
  @PostMapping("/api/v1/polls")
  public void addNewPoll(@RequestBody PollTO poll) {
    template.update(
      "insert into polls(poll_id, question) values (?,?)",
      poll.getPoll_id(),
      poll.getQuestion()
    );
  }

  @CrossOrigin
  @ApiOperation("Get all Polls")
  @Override
  @GetMapping("/api/v1/polls")
  public List<PollTO> viewAllPolls() {
    return this.template.query(
        "select * from polls",
        new BeanPropertyRowMapper<PollTO>(PollTO.class)
      );
  }

  @CrossOrigin
  @ApiOperation("Get Poll by ID")
  @Override
  @GetMapping("/api/v1/polls/{id}")
  public PollTO viewPollById(@PathVariable("id") String id) {
    return (PollTO) template.queryForObject(
      "select * from polls where poll_id = ?",
      new Object[] { id },
      new BeanPropertyRowMapper(PollTO.class)
    );
  }

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

  //Options Controller

  @CrossOrigin
  @ApiOperation("Add an Option")
  @Override
  @PostMapping("/api/v1/options")
  public void addNewOptions(@RequestBody OptionTO option) {
    template.update(
      "insert into options (option_id, poll_id, content) values(?,?,?)",
      option.getOption_id(),
      option.getPoll_id(),
      option.getContent()
    );
  }

  @CrossOrigin
  @ApiOperation("Get all Options")
  @Override
  @GetMapping("/api/v1/options")
  public List<OptionTO> getAllOptions() {
    return this.template.query(
        "select * from options",
        new BeanPropertyRowMapper<OptionTO>(OptionTO.class)
      );
  }

  @CrossOrigin
  @ApiOperation("Get an Option by ID")
  @Override
  @GetMapping("/api/v1/options/{id}")
  public OptionTO getOptionById(@PathVariable("id") String id) {
    return (OptionTO) template.queryForObject(
      "select * from options where option_id = ?",
      new Object[] { id },
      new BeanPropertyRowMapper(OptionTO.class)
    );
  }

  @CrossOrigin
  @ApiOperation("Get options by poll id")
  @Override
  @GetMapping("/api/v1/options/polls/{id}")
  public List<OptionTO> getOptionsByPollsId(@PathVariable("id") String id) {
    return this.template.query(
        "select * from options where poll_id = ?",
        new Object[] { id },
        new BeanPropertyRowMapper<>(OptionTO.class)
      );
  }

  // Response Controller

  @CrossOrigin
  @ApiOperation("Add a Response")
  @Override
  @PostMapping("/api/v1/responses")
  public void addNewResponse(@RequestBody ResponseTO Response) {
    template.update(
      "insert into responses(poll_id, option_id) values (?,?)",
      Response.getPoll_id(),
      Response.getOption_id()
    );
  }

  @CrossOrigin
  @ApiOperation("Get all Responses")
  @Override
  @GetMapping("/api/v1/responses")
  public List<ResponseTO> viewAllResponse() {
    return this.template.query(
        "select * from responses",
        new BeanPropertyRowMapper<ResponseTO>(ResponseTO.class)
      );
  }

  @CrossOrigin
  @ApiOperation("Get Response by ID")
  @Override
  @GetMapping("/api/v1/responses/{id}")
  public ResponseTO viewResponseById(@PathVariable("id") String id) {
    return (ResponseTO) template.queryForObject(
      "select * from responses where response_id = ?",
      new Object[] { id },
      new BeanPropertyRowMapper<>(ResponseTO.class)
    );
  }

  @CrossOrigin
  @ApiOperation("Get response by poll id")
  @Override
  @GetMapping("/api/v1/response/polls/{id}")
  public List<ResponseTO> getResponsesByPollsId(@PathVariable("id") String id) {
    return this.template.query(
        "select * from responses where poll_id = ?",
        new Object[] { id },
        new BeanPropertyRowMapper<>(ResponseTO.class)
      );
  }
}

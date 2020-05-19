package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.models.ResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
public class ResponseController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Response")
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
    @GetMapping("/api/v1/responses")
    public List<ResponseTO> viewAllResponse() {
        return this.template.query(
                "select * from responses",
                new BeanPropertyRowMapper<ResponseTO>(ResponseTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get Response by ID")
    @GetMapping("/api/v1/responses/{id}")
    public ResponseTO viewResponseById(@PathVariable("id") Integer id) {
        return this.template.queryForObject(
                "select poll_id, response_id, option_id from responses where response_id =",
                new Object[]{id},
                new BeanPropertyRowMapper<>(ResponseTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get response by poll id")
    @GetMapping("/api/v1/response/polls/{id}")
    public List<ResponseTO> getResponsesByPollsId(@PathVariable("id") String id) {
        return this.template.query(
                "select * from responses where poll_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(ResponseTO.class)
        );
    }
}


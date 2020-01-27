package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.dao.ResponseDAO;
import io.turntabl.Polls.models.ResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class ResponseController implements ResponseDAO {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Response")
    @Override
    @PostMapping("/api/v1/responses")
    public void addNewResponse(@RequestBody ResponseTO Response) {
        template.update("insert into responses(response_id, options_id, suggestions) values (?,?,?)", Response.getResponse_id(), Response.getOptions_id(), Response.getSuggestions());
    }


    @CrossOrigin
    @ApiOperation("Delete a Response")
    @Override
    @DeleteMapping("/api/v1/responses/{id}")
    public void deleteResponse(@PathVariable("id") String id) {
        template.update("delete from responses where response_id = ?", id);
    }

    @CrossOrigin
    @ApiOperation("Get all Responses")
    @Override
    @GetMapping("/api/v1/responses")
    public List<ResponseTO> viewAllResponse() {
        return this.template.query("select * from responses", new BeanPropertyRowMapper<ResponseTO>(ResponseTO.class));
    }


    @CrossOrigin
    @ApiOperation("Get Response by ID")
    @Override
    @GetMapping("/api/v1/responses/{id}")
    public ResponseTO viewResponseById(@PathVariable("id") String id) {
        return (ResponseTO) template.queryForObject("select * from responses where response_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(ResponseTO.class));
    }
}

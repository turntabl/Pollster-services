package io.turntabl.Polls.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Polls.dao.UserDAO;
import io.turntabl.Polls.models.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class UserController implements UserDAO {

    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Get all Creators")
    @Override
    @GetMapping("/api/v1/creators")
    public List<UserTO> getAllCreators() {
        return this.template.query("select * from creators", new BeanPropertyRowMapper<UserTO>(UserTO.class));
    }

    @CrossOrigin
    @ApiOperation("Add a Creator")
    @Override
    @PostMapping("/api/v1/creators")
    public void AddNewCreator(UserTO creator) {
        template.update("insert into creators (creator_id, creator_email, creator_name) values (?,?,?)", creator.getCreator_id(),creator.getCreator_email(), creator.getCreator_name());
    }

    @CrossOrigin
    @ApiOperation("Get Creator by ID")
    @Override
    @GetMapping("/api/v1/creators/{id}")
    public UserTO getCreatorById(@PathVariable("id") String id) {
         return (UserTO)  template.queryForObject("select * from creators where creator_id = ?", new Object[]{id},
                new BeanPropertyRowMapper(UserTO.class));
    }

    @CrossOrigin
    @ApiOperation("Delete a Creator")
    @Override
    @DeleteMapping("/api/v1/creators/{id}")
    public void deleteCreator(@PathVariable("id") String id) {
        template.update("delete from creators where creator_id = ?", id);
    }
}

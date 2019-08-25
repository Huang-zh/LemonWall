package lemonWall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/")
    public String index(){
        return "/index";
    }

}

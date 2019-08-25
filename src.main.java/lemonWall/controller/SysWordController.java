package lemonWall.controller;

import lemonWall.entity.SysWord;
import lemonWall.service.SysWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sysWord")
public class SysWordController extends BaseController{
    @Autowired
    SysWordService sysWordService;
    @RequestMapping("")
    public String index(){
        return "/LemonWall";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(SysWord sysWord){
        return sysWordService.getData(sysWord);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(SysWord sysWord){
        boolean flag = sysWordService.save(sysWord);
        if (flag)
            return success();
        else
            return error();
    }

    @RequestMapping("/del")
    @ResponseBody
    public Object del(SysWord sysWord){
        boolean flag = sysWordService.del(sysWord);
        if (flag)
            return success();
        else
            return error();
    }
}

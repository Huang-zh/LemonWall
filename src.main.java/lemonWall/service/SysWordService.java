package lemonWall.service;

import com.alibaba.fastjson.JSONObject;
import lemonWall.dao.SysWordDao;
import lemonWall.entity.SysWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysWordService")
public class SysWordService {

    @Autowired
    SysWordDao wordDao;
    public JSONObject getData(SysWord sysWord){
        return wordDao.getData(sysWord);
    }

    public boolean save(SysWord sysWord){
        return wordDao.save(sysWord);
    }

    public boolean del(SysWord sysWord){
        return wordDao.del(sysWord);
    }
}

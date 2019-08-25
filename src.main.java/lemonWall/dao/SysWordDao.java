package lemonWall.dao;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lemonWall.LemonUtil;
import lemonWall.entity.SysWord;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  @author: huang.zh
 *  @Date: 2019/8/24 0024 0:34
 *  @Description:
 */
@Repository("sysWordDao")
public class SysWordDao extends BaseDao{
    private static final String sql = "  SELECT *,SUBSTR(time,1,7) AS yearMonth FROM sys_words WHERE del_flag = 0  ";

    public JSONObject getData(SysWord sysWord){
        JSONObject jsonObject = new JSONObject();
        String SQL = sql;
        if (null != sysWord.getYear())
            SQL += " AND YEAR(time) = "+sysWord.getYear();
        SQL += " ORDER BY time DESC ";
        if (null != sysWord.getPage()){
            SQL += " LIMIT "+(sysWord.getPage()-1)*10 + ","+sysWord.getPage()*10;
        } else {
            SQL += " LIMIT 0,10";
        }
        List<Map<String,Object>> list = jdbcTemplate.queryForList(SQL);
        String yearMonth = "";
        JSONArray array = new JSONArray();
        for (Map<String,Object> data : list){
            if (!String.valueOf(data.get("yearMonth")).equals(yearMonth)){
                if (array.size() > 0){
                    jsonObject.put(yearMonth,array);
                    array = new JSONArray();
                }
                yearMonth = String.valueOf(data.get("yearMonth"));
            }
            JSONObject object = new JSONObject();
            object.putAll(data);
            array.add(object);
        }
        jsonObject.put(yearMonth,array);
        return jsonObject;
    }

    public boolean save(SysWord sysWord){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String insert_sql = " INSERT INTO sys_words (words,time) VALUES('"+sysWord.getWords()+"','"
                + Timestamp.valueOf(sdf.format(new Date())) +"') ";
        try {
            execute(insert_sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean del(SysWord sysWord){
        String sql = " UPDATE sys_words SET del_flag = '0' WHERE id = "+sysWord.getId();
        try {
            execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}

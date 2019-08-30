package lemonWall.dao;

import lemonWall.entity.SysPhoto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huang.zh
 * @Date: 2019/8/28 14:40
 * @Description:
 */
@Repository("galleryDao")
public class GalleryDao extends BaseDao {

    private static final String sql = " SELECT * FROM sys_photo WHERE del_flag = 0 ";

    public List<SysPhoto> getPhotos(){
        String SQL = sql;
        SQL += " ORDER BY time DESC LIMIT 10";
        try {
            return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(SysPhoto.class));
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

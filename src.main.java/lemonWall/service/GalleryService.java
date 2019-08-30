package lemonWall.service;

import com.alibaba.fastjson.JSONObject;
import lemonWall.dao.GalleryDao;
import lemonWall.entity.SysPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: huang.zh
 * @Date: 2019/8/28 14:46
 * @Description:
 */
@Service("galleryService")
public class GalleryService {

    @Autowired
    GalleryDao galleryDao;

    public List<SysPhoto> getPhotos(){
        return galleryDao.getPhotos();
    }
}

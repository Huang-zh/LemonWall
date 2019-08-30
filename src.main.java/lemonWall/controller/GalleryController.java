package lemonWall.controller;

import lemonWall.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: huang.zh
 * @Date: 2019/8/28 14:07
 * @Description:
 */
@RequestMapping("/gallery")
@Controller
public class GalleryController extends BaseController{

    @Autowired
    GalleryService galleryService;

    @RequestMapping("")
    public String index(){
        return "/gallery";
    }

    @RequestMapping("/getPhotos")
    @ResponseBody
    public Object getPhotos(){
        return galleryService.getPhotos();
    }
}

package com.ribeiro.gallery.controller.impl;

import com.ribeiro.gallery.api.PictureInfo;
import com.ribeiro.gallery.controller.api.PictureInfoController;
import com.ribeiro.gallery.service.api.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PictureInfoControllerImpl implements PictureInfoController {
    private static final String REST_MAPPING_PICTURES = "/pictures";

    private final PictureService pictureService;

    @Autowired
    public PictureInfoControllerImpl(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @Override
    @RequestMapping(value = REST_MAPPING_PICTURES, params = {"page", "size"}, method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<PictureInfo> getPicturesInfoList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return pictureService.findPictures(page, size);
    }
}


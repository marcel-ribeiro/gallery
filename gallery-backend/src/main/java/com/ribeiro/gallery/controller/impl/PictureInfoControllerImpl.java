package com.ribeiro.gallery.controller.impl;

import com.ribeiro.gallery.api.PictureInfo;
import com.ribeiro.gallery.controller.api.PictureInfoController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PictureInfoControllerImpl implements PictureInfoController {
    private static final String REST_MAPPING_PICTURES = "/pictures";

    @RequestMapping(REST_MAPPING_PICTURES)
    public List<PictureInfo> getPicturesInfoList() {
        //TODO: This was temporarily hardcoded, just to test it out
        PictureInfo pictureInfo1 = new PictureInfo();
        pictureInfo1.setId("1");
        pictureInfo1.setName("Name-1");
        pictureInfo1.setCreatedAt("12334876544678");
        pictureInfo1.setCreatedAt("http://www.mypictureurl.com/1");

        PictureInfo pictureInfo2 = new PictureInfo();
        pictureInfo2.setId("2");
        pictureInfo2.setName("Name-2");
        pictureInfo2.setCreatedAt("0987675678");
        pictureInfo2.setCreatedAt("http://www.mypictureurl.com/2");


        return new ArrayList<>(
                Arrays.asList(pictureInfo1, pictureInfo2));
    }
}


package com.ribeiro.gallery.service.impl;

import com.ribeiro.gallery.model.PictureInfo;
import com.ribeiro.gallery.service.api.PictureRestCosumerService;
import com.ribeiro.gallery.service.api.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRestCosumerService pictureRestCosumerService;

    @Autowired
    public PictureServiceImpl(PictureRestCosumerService pictureRestCosumerService) {
        this.pictureRestCosumerService = pictureRestCosumerService;
    }

    @Override
    public List<PictureInfo> findPictures(int page, int size) {

        List<PictureInfo> pictureInfoList = new ArrayList<>();
        int start = (page <= 0 ? page : page - 1) * size + 1;
        int end = start + size - 1;
        for (int currentId = start; currentId <= end; currentId++) {
            PictureInfo pictureInfo = pictureRestCosumerService.getPictureInfo(String.valueOf(currentId));
            if(pictureInfo != null){
                pictureInfoList.add(pictureInfo);

            }
        }

        return pictureInfoList;
    }
}
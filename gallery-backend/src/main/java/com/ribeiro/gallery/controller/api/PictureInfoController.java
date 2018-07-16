package com.ribeiro.gallery.controller.api;

import com.ribeiro.gallery.model.PictureInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller use to expose a REST API to the UI to retrieve the list of pictures available
 */
public interface PictureInfoController {
    /**
     * Provides a list of Picture Infos to be displayed by the UI
     *
     * @return List<PictureInfo>
     */
    List<PictureInfo> getPicturesInfoList(@RequestParam("page") int page, @RequestParam("size") int size);
}

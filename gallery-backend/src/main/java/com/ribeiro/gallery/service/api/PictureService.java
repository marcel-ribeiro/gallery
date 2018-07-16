package com.ribeiro.gallery.service.api;

import com.ribeiro.gallery.model.PictureInfo;

import java.util.List;

/**
 * Interface for the service that will perform the picture searches
 */
public interface PictureService {
    /**
     * Service that creates a pagination mechanism so the pictures are not all loaded at once.
     *
     * @param page number of the page being retrieved (start point)
     * @param size size of the page (number of pictures
     * @return List<PictureInfo>
     */
    List<PictureInfo> findPictures(int page, int size);
}

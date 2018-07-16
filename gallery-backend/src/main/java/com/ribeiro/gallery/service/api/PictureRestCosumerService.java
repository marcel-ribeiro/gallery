package com.ribeiro.gallery.service.api;

import com.ribeiro.gallery.model.PictureInfo;

/**
 * Interface for the service that will communicate with the 3rd party provider and return the list of pictures available
 */
public interface PictureRestCosumerService {

    /**
     * Receives the id of a picture and sends rest call for the 3rd party provider to retrieve the information for the given picture
     *
     * @param id Id of the picture being searched
     * @return PictureInfo
     */
    PictureInfo getPictureInfo(String id);
}

package com.ribeiro.gallery.service.api;

import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Service created to centralize the creation of rest template objects
 */
public interface RestTemplateService {
    /**
     * Method that instantiate and returns a RestTemplate object
     *
     * @return a RestTemplate object
     */
    RestTemplate getRestTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
}

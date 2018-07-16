package com.ribeiro.gallery.service.impl;

import com.ribeiro.gallery.api.PictureInfo;
import com.ribeiro.gallery.service.api.PictureRestCosumerService;
import com.ribeiro.gallery.service.api.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Service
public class PictureRestCosumerServiceImpl implements PictureRestCosumerService {
    private static final String REST_3RD_PARTY_PROVIDER = "https://5ad8d1c9dc1baa0014c60c51.mockapi.io/api/br/v1/magic/";

    private final RestTemplateService restTemplateService;

    @Autowired
    public PictureRestCosumerServiceImpl(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @Override
    public PictureInfo getPictureInfo(String id) {
        String urlOverHttps = REST_3RD_PARTY_PROVIDER + id;
        RestTemplate restTemplate;
        try {
            restTemplate = restTemplateService.getRestTemplate();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
            return null;
        }

        try {
            ResponseEntity<PictureInfo> exchange = restTemplate.exchange(urlOverHttps, HttpMethod.GET, null, PictureInfo.class);
            return exchange.getBody();
        } catch (HttpClientErrorException e) {
            return null;
        }
    }


}
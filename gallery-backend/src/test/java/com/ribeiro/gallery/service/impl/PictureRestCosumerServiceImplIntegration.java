package com.ribeiro.gallery.service.impl;

import com.ribeiro.gallery.model.PictureInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureRestCosumerServiceImplIntegration {
    @Autowired
    PictureRestCosumerServiceImpl pictureRestCosumerService;

    @Test
    public void shouldReceiveOkResponse() throws Exception {
        //given
        String id = "12";
        String expectedName = "name 12";
        String expectedCreatedAt = "1524158544";
        String expectedImageUrl = "https://unsplash.it/500?image=12";
        //when
        PictureInfo pictureInfo = pictureRestCosumerService.getPictureInfo(id);
        //then
        assertThat(pictureInfo).isNotNull();
        assertThat(pictureInfo.getId()).isEqualTo(id);
        assertThat(pictureInfo.getName()).isEqualTo(expectedName);
        assertThat(pictureInfo.getCreatedAt()).isEqualTo(expectedCreatedAt);
        assertThat(pictureInfo.getImageUrl()).isEqualTo(expectedImageUrl);
    }

    @Test
    public void shouldReceiveNotFoundResponse() throws Exception {
        //given
        String id = "120";
        //when
        PictureInfo pictureInfo = pictureRestCosumerService.getPictureInfo(id);
        //then
        assertThat(pictureInfo).isNull();
    }
}
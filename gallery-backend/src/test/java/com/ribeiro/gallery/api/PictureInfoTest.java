package com.ribeiro.gallery.api;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class PictureInfoTest {

    @Test
    public void shouldNotThrowExceptionFromtoStringWhenIdIsNull() {
        //given
        PictureInfo pictureInfo = new PictureInfo();
        pictureInfo.setId(null);
        pictureInfo.setCreatedAt("SOME_TIMESTAMP");
        pictureInfo.setImageUrl("SOME_URL");
        pictureInfo.setName("SOME_NAME");

        //when
        String toString = pictureInfo.toString();

        //then
        assertThat(toString).isNotNull();
    }

}
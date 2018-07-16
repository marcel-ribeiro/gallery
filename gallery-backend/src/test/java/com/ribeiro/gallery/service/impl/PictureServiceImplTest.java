package com.ribeiro.gallery.service.impl;

import com.ribeiro.gallery.api.PictureInfo;
import com.ribeiro.gallery.service.api.PictureRestCosumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureServiceImplTest {
    @Spy
    @InjectMocks
    private PictureServiceImpl pictureService;

    @Mock
    private PictureRestCosumerService pictureRestCosumerService;


    @Test
    public void shouldRequestPicturesFromTheFirstPage() throws Exception {
        //given
        Mockito.when(pictureRestCosumerService.getPictureInfo(Mockito.isA(String.class))).thenReturn(null);

        //when
        List<PictureInfo> pictures = pictureService.findPictures(0, 3);

        //then
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("1"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("2"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("3"));
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("4"));
    }

    @Test
    public void shouldRequestPicturesFromSecondPage() throws Exception {
        //given
        Mockito.when(pictureRestCosumerService.getPictureInfo(Mockito.isA(String.class))).thenReturn(null);

        //when
        List<PictureInfo> pictures = pictureService.findPictures(2, 3);

        //then
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("1"));
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("3"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("4"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("5"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("6"));
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("7"));
    }

    @Test
    public void shouldRequestPicturesForPagesWithSize5() throws Exception {
        //given
        Mockito.when(pictureRestCosumerService.getPictureInfo(Mockito.isA(String.class))).thenReturn(null);

        //when
        List<PictureInfo> pictures = pictureService.findPictures(3, 5);

        //then
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("10"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("11"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("12"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("13"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("14"));
        verify(pictureRestCosumerService).getPictureInfo(Mockito.eq("15"));
        verify(pictureRestCosumerService, never()).getPictureInfo(Mockito.eq("16"));

    }

}
package com.ribeiro.gallery.service.impl;

import com.ribeiro.gallery.api.PictureInfo;
import com.ribeiro.gallery.service.api.RestTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureRestCosumerServiceImplTest {
    @InjectMocks
    private PictureRestCosumerServiceImpl pictureRestCosumerService;

    @Mock
    private RestTemplateService restTemplateService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ResponseEntity<PictureInfo> responseEntity;

    @Test
    public void shouldReceiveValidPictureInfoResponse() throws Exception {
        //given
        String id = "1";
        String expectedName = "expectedName";
        String expectedCreatedAt = "expectedCreatedAt";
        String expectedImageUrl = "expectedImageUrl";
        PictureInfo expectedPictureInfo = createPictureInfo(id, expectedName, expectedCreatedAt, expectedImageUrl);

        Mockito.when(responseEntity.getBody()).thenReturn(expectedPictureInfo);
        Mockito.when(restTemplate.exchange(Mockito.isA(String.class), Mockito.eq(HttpMethod.GET), Mockito.isNull(), Mockito.eq(PictureInfo.class))).thenReturn(responseEntity);
        Mockito.when(restTemplateService.getRestTemplate()).thenReturn(restTemplate);

        //when
        PictureInfo pictureInfo = pictureRestCosumerService.getPictureInfo(id);

        //then
        verify(restTemplate).exchange(Mockito.isA(String.class), Mockito.eq(HttpMethod.GET), Mockito.isNull(), Mockito.eq(PictureInfo.class));
        assertThat(pictureInfo).isNotNull();
        assertThat(pictureInfo.getId()).isEqualTo(id);
        assertThat(pictureInfo.getName()).isEqualTo(expectedName);
        assertThat(pictureInfo.getCreatedAt()).isEqualTo(expectedCreatedAt);
        assertThat(pictureInfo.getImageUrl()).isEqualTo(expectedImageUrl);
    }

    @Test
    public void shouldReceiveNoPictureInfoResponseWhenAnExceptionIsThrown() throws Exception {
        //given
        String id = "1";
        String expectedName = "expectedName";
        String expectedCreatedAt = "expectedCreatedAt";
        String expectedImageUrl = "expectedImageUrl";
        PictureInfo expectedPictureInfo = createPictureInfo(id, expectedName, expectedCreatedAt, expectedImageUrl);

        Mockito.when(responseEntity.getBody()).thenReturn(expectedPictureInfo);
        Mockito.when(restTemplate.exchange(Mockito.isA(String.class), Mockito.eq(HttpMethod.GET), Mockito.isNull(), Mockito.eq(PictureInfo.class))).thenThrow(HttpClientErrorException.class);
        Mockito.when(restTemplateService.getRestTemplate()).thenReturn(restTemplate);

        //when
        PictureInfo pictureInfo = pictureRestCosumerService.getPictureInfo(id);

        //then
        verify(restTemplate).exchange(Mockito.isA(String.class), Mockito.eq(HttpMethod.GET), Mockito.isNull(), Mockito.eq(PictureInfo.class));
        assertThat(pictureInfo).isNull();
    }

    private PictureInfo createPictureInfo(String id, String expectedName, String expectedCreatedAt, String expectedImageUrl) {
        PictureInfo expectedPictureInfo = new PictureInfo();
        expectedPictureInfo.setId(id);
        expectedPictureInfo.setName(expectedName);
        expectedPictureInfo.setCreatedAt(expectedCreatedAt);
        expectedPictureInfo.setImageUrl(expectedImageUrl);
        return expectedPictureInfo;
    }
}
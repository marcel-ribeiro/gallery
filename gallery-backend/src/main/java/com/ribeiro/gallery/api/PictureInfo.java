package com.ribeiro.gallery.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.core.style.ToStringCreator;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PictureInfo {
    private String id;
    private String createdAt;
    private String name;
    private String imageUrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Overrides the toString() method to display the PictureInfo properties
     *
     * @return PictureInfo as a string
     */
    @Override
    public String toString() {
        ToStringCreator toStringCreator = new ToStringCreator(this);
        return toStringCreator.append("id", id)
                .append("createdAt", createdAt)
                .append("name", name)
                .append("imageUrl", imageUrl)
                .toString();
    }
}

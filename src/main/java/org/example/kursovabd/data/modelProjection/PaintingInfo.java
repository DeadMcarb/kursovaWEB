package org.example.kursovabd.data.modelProjection;

/**
 * Projection for {@link org.example.kursovabd.data.Painting}
 */
public interface PaintingInfo {
    Integer getId();

    String getName();

    Integer getOriginaly();

    Double getWorth();

    Integer getRoomId();

    String getDescription();



    String getArtist();

    String getStyle();

    String getGenre();

    String getFavourite();
}
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

    ArtistInfo getArtist();

    StyleInfo getStyle();

    GenreInfo getGenre();

    /**
     * Projection for {@link org.example.kursovabd.data.Artist}
     */
    interface ArtistInfo {
        String getName();
    }

    /**
     * Projection for {@link org.example.kursovabd.data.Style}
     */
    interface StyleInfo {
        String getName();
    }

    /**
     * Projection for {@link org.example.kursovabd.data.Genre}
     */
    interface GenreInfo {
        String getName();
    }
}
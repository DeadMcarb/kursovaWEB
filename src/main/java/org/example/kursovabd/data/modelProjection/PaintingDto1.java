package org.example.kursovabd.data.modelProjection;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.kursovabd.data.Painting}
 */
@Value
public class PaintingDto1 implements Serializable {
    Integer id;
    String name;
    String artistName;
    String styleName;
    String genreName;
    Integer originaly;
    Double worth;
    Integer roomId;
    String description;
}
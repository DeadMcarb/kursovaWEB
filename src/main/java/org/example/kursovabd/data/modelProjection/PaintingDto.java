package org.example.kursovabd.data.modelProjection;

import lombok.*;

/**
 * DTO for {@link Painting}
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaintingDto {
    private Integer id;
    private String paintingName;
    private String artistName;
    private String styleName;
    private String genreName;
    private Integer originaly;
    private Double worth;
    private Integer roomId;
    private String description;

}


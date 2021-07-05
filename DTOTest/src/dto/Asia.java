package DTOTest.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Asia {
    private String capital;
    private String name;
    private int population;
    private int gdp;
    private String location;
    private String language;
}

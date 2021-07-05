package DTOTest.src.main;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.spi.MatchingStrategy;
import org.modelmapper.spi.NameTokenizer;

import DTOTest.src.dto.Asia;
import DTOTest.src.dto.Country;

public class MapperTest {

    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE).setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.getConfiguration().setDeepCopyEnabled(true);

        Country country1 = Country.builder().name("Korea").capital("Seoul").gdp(16000).population(50000).build();
        Country country2 = modelMapper.map(country1, country1.getClass());

        System.out.println(country1.toString());
        System.out.println(country2.toString());
        country1.setName("Japan");
        System.out.println(country1.toString());
        System.out.println(country2.toString());
        country2.setName("China");
        System.out.println(country1.toString());
        System.out.println(country2.toString());
        System.out.println(country1.hashCode());
        System.out.println(country2.hashCode());

        Asia asia = new Asia();
        asia = modelMapper.map(country2, Asia.class);
        asia.setLanguage("Chinese");
        asia.setLocation("East");
        System.out.println(asia.toString());
        System.out.println(asia.hashCode());
    }
}

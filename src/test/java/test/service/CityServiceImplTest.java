package test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.RestApplication;
import test.domain.dto.CityDto;
import test.domain.dto.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@SpringBootTest(classes = RestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceImplTest {

    @Autowired
    CityService cityService;

    @Test
    public void findCitiesByName() {
        // ARRANGE
        List<String> expectedCities = Arrays.asList("Cairns", "London", "Mountain View", "Shuzenji");

        // ACT
        List<CityDto> actualCities = cityService.findCitiesByName(expectedCities);

        // ASSERT
        for (int i = 0; i < expectedCities.size(); i++) {
            assertEquals(expectedCities.get(i), actualCities.get(i).getName());
            System.out.println(actualCities.get(i).getName());
        }
    }

    @Test
    public void getCityWithMinTemp() {
        // ARRANGE
        CityDto london = new CityDto(new Main(30, 0, 0, 30, 33), "London");
        CityDto cairns = new CityDto(new Main(30, 0, 0, 30, 5), "Cairns");
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(london);
        cityDtoList.add(cairns);

        // ACT
        CityDto actualCityDto = cityService.getCityWithMinTemp(cityDtoList);

        // ASSERT
        assertThat(actualCityDto.getName()).isEqualTo(cairns.getName());
        assertThat(actualCityDto.getMain().getTemp_max()).isEqualTo(cairns.getMain().getTemp_max());
    }

    @Test
    public void getCityWithMaxTemp() {
        // ARRANGE
        CityDto london = new CityDto(new Main(30, 0, 0, 30, 33), "London");
        CityDto cairns = new CityDto(new Main(30, 0, 0, 30, 5), "Cairns");
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(london);
        cityDtoList.add(cairns);

        // ACT
        CityDto actualCityDto = cityService.getCityWithMaxTemp(cityDtoList);

        // ASSERT
        assertThat(actualCityDto.getName()).isEqualTo(london.getName());
        assertThat(actualCityDto.getMain().getTemp_max()).isEqualTo(london.getMain().getTemp_max());
    }

    @Test
    public void getCityGreaterTempRate() {
        // ARRANGE
        CityDto london = new CityDto(new Main(30, 0, 0, 30, 33), "London");
        CityDto cairns = new CityDto(new Main(10, 0, 0, 1, 11), "Cairns");
        List<CityDto> cityDtoList = new ArrayList<>();
        cityDtoList.add(london);
        cityDtoList.add(cairns);

        // ACT
        CityDto actualCityDto = cityService.getCityWithGreaterTempRange(cityDtoList);

        // ASSERT
        assertThat(actualCityDto.getName()).isEqualTo(cairns.getName());
        //check greater temp range
        assertThat(actualCityDto.getMain().getTemp_max() - actualCityDto.getMain().getTemp_min())
                .isEqualTo(cairns.getMain().getTemp_max() - cairns.getMain().getTemp_min());
    }
}

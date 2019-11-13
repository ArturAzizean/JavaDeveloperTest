package test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.domain.City;
import test.domain.CityRequest;
import test.domain.CityResponse;
import test.domain.dto.CityDto;
import test.service.CityService;

import java.util.List;

@RestController
public class WeatherController {
    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);
    private final CityService cityService;

    public WeatherController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/cities", produces = "application/json")
    public ResponseEntity<CityResponse> getCitiesWithMaxAndMinTemperature(@RequestBody CityRequest citiesRequest) {
        List<CityDto> cityDtoList;

        try {
            cityDtoList = cityService.findCitiesByName(citiesRequest.getCityNames());

            return ResponseEntity.ok(new CityResponse(
                    mapCityDtoToPojo(cityService.getCityWithMaxTemp(cityDtoList)),
                    mapCityDtoToPojo(cityService.getCityWithMinTemp(cityDtoList)),
                    mapCityDtoToPojo(cityService.getCityWithGreaterTempRange(cityDtoList))
            ));
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            LOG.debug(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    private City mapCityDtoToPojo(CityDto dto) {
        return new City(dto.getName(), dto.getMain().getTemp_max(), dto.getMain().getTemp_max() - dto.getMain().getTemp_min());
    }
}

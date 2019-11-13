package test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.domain.City;
import test.domain.dto.CityDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Value("${weathermap.apikey}")
    private String apikey;

    private final RestTemplate restTemplate;

    public CityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CityDto> findCitiesByName(List<String> citiesNames) {
        return citiesNames.stream()
                .map(s -> restTemplate.getForObject(
                        "https://openweathermap.org/data/2.5/weather?q=" + s + "&appid=" + apikey, CityDto.class
                )).collect(Collectors.toList());
    }

    @Override
    public CityDto getCityWithMinTemp(List<CityDto> cityDtoList) {
        Optional<CityDto> cityWithMinTemp;

        List<Float> allTemp = cityDtoList.stream()
                .map(cityDto -> cityDto.getMain().getTemp_max()).collect(Collectors.toList());

        float minTemp = Collections.min(allTemp);

        cityWithMinTemp = cityDtoList.stream().filter(cityDto -> cityDto.getMain().getTemp_max() == minTemp).findFirst();

        return cityWithMinTemp.orElse(null);
    }

    @Override
    public CityDto getCityWithMaxTemp(List<CityDto> cityDtoList) {
        Optional<CityDto> cityWithMaxTemp;

        List<Float> allTemp = cityDtoList.stream()
                .map(cityDto -> cityDto.getMain().getTemp_max()).collect(Collectors.toList());

        float maxTemp = Collections.max(allTemp);

        cityWithMaxTemp = cityDtoList.stream().filter(cityDto -> cityDto.getMain().getTemp_max() == maxTemp).findFirst();

        return cityWithMaxTemp.orElse(null);
    }

    @Override
    public CityDto getCityWithGreaterTempRange(List<CityDto> cityDtoList) {
        Optional<CityDto> cityWithGreaterRange;

        List<Float> allTempRange = cityDtoList.stream()
                .map(cityDto ->
                        cityDto.getMain().getTemp_max() - cityDto.getMain().getTemp_min()).collect(Collectors.toList());

        float greaterTempRange = Collections.max(allTempRange);

        cityWithGreaterRange = cityDtoList.stream().filter(cityDto ->
                (cityDto.getMain().getTemp_max() - cityDto.getMain().getTemp_min()) == greaterTempRange).findFirst();

        return cityWithGreaterRange.orElse(null);
    }
}

package test.service;

import test.domain.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findCitiesByName(List<String> citiesNames);

    CityDto getCityWithMinTemp(List<CityDto> cityDtoPojoList);

    CityDto getCityWithMaxTemp(List<CityDto> cityDtoPojoList);

    CityDto getCityWithGreaterTempRange(List<CityDto> cityDtoList);
}

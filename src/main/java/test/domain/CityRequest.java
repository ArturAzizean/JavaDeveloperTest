package test.domain;

import java.util.ArrayList;
import java.util.List;

public class CityRequest {
    private List<String> cityName = new ArrayList<>();

    public CityRequest() {
    }

    public CityRequest(List<String> cityName) {
        this.cityName = cityName;
    }

    public List<String> getCityNames() {
        return cityName;
    }

    public void setCityName(ArrayList<String> cityName) {
        this.cityName = cityName;
    }
}

package test.domain;

public class CityResponse {
    private City cityWithMaxTemp;
    private City cityWithMinTemp;
    private City cityWithGreaterTempRange;

    public CityResponse() {
    }

    public CityResponse(City cityWithMaxTemp, City cityWithMinTemp, City cityWithGreaterTempRange) {
        this.cityWithMaxTemp = cityWithMaxTemp;
        this.cityWithMinTemp = cityWithMinTemp;
        this.cityWithGreaterTempRange = cityWithGreaterTempRange;
    }

    public City getCityWithMaxTemp() {
        return cityWithMaxTemp;
    }

    public void setCityWithMaxTemp(City CityWithMaxTemp) {
        this.cityWithMaxTemp = CityWithMaxTemp;
    }

    public City getCityWithMinTemp() {
        return cityWithMinTemp;
    }

    public void setCityWithMinTemp(City CityWithMinTemp) {
        this.cityWithMinTemp = CityWithMinTemp;
    }

    public City getCityWithGreaterTempRange() {
        return cityWithGreaterTempRange;
    }

    public void setCityWithGreaterTempRange(City cityWithGreaterTempRange) {
        this.cityWithGreaterTempRange = cityWithGreaterTempRange;
    }
}

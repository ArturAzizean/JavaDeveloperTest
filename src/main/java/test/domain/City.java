package test.domain;

public class City {
    private String name = "";
    private float temp_max = 0;
    private float temp_range = 0;

    public City() {
    }

    public City(String name, float temp_max, float temp_range) {
        this.name = name;
        this.temp_max = temp_max;
        this.temp_range = temp_range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getTemp_range() {
        return temp_range;
    }

    public void setTemp_range(float temp_range) {
        this.temp_range = temp_range;
    }
}

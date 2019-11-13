package test.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {
    private Coord CoordObject;
    ArrayList< Object > weather = new ArrayList < Object > ();
    private String base;
    private Main MainObject;
    private float visibility;
    private Wind WindObject;
    private Clouds CloudsObject;
    private float dt;
    private Sys SysObject;
    private float id;
    private String name;
    private float cod;

    public CityDto() {
    }

    public CityDto(Main mainObject, String name) {
        MainObject = mainObject;
        this.name = name;
    }

    public CityDto(Coord coordObject, ArrayList<Object> weather, String base, Main mainObject, float visibility, Wind windObject, Clouds cloudsObject, float dt, Sys sysObject, float id, String name, float cod) {
        CoordObject = coordObject;
        this.weather = weather;
        this.base = base;
        MainObject = mainObject;
        this.visibility = visibility;
        WindObject = windObject;
        CloudsObject = cloudsObject;
        this.dt = dt;
        SysObject = sysObject;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    // Getter Methods

    public Coord getCoord() {
        return CoordObject;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return MainObject;
    }

    public float getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return WindObject;
    }

    public Clouds getClouds() {
        return CloudsObject;
    }

    public float getDt() {
        return dt;
    }

    public Sys getSys() {
        return SysObject;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCod() {
        return cod;
    }

    // Setter Methods

    public void setCoord(Coord coordObject) {
        this.CoordObject = coordObject;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(Main mainObject) {
        this.MainObject = mainObject;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind windObject) {
        this.WindObject = windObject;
    }

    public void setClouds(Clouds cloudsObject) {
        this.CloudsObject = cloudsObject;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setSys(Sys sysObject) {
        this.SysObject = sysObject;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }
}


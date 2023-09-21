package ru.aston.morozov_aa.task6.stream_api;

public enum City {
    GOMEL("Гомель"),
    MINSK("Минск"),
    MOGILEV("Могилёв"),
    BREST("Брест");

    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}

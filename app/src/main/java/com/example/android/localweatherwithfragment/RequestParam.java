package com.example.android.localweatherwithfragment;

public class RequestParam {
    String cityName;
    String unitGroup;
    String include;
    String key;
    String contentType;

    public RequestParam(String cityName,
                        String unitGroup,
                        String include,
                        String key,
                        String contentType) {
        this.cityName = cityName;
        this.unitGroup = unitGroup;
        this.include = include;
        this.key = key;
        this.contentType = contentType;
    }
}
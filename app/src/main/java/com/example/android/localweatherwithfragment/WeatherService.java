package com.example.android.localweatherwithfragment;

import com.example.android.localweatherwithfragment.DataModel.RawDto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    //https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Seattle?unitGroup=metric&include=days%2Ccurrent&key=UDR74JLWCB3CRZBZQSTL3AVQH&contentType=json
    @GET("VisualCrossingWebServices/rest/services/timeline/{cityName}")
    Observable<RawDto> getData(@Path("cityName") String cityName,//Seattle
                               @Query("unitGroup") String unitGroup,//metric
                               @Query("key") String key,//UDR74JLWCB3CRZBZQSTL3AVQH
                               @Query("contentType") String contentType);//json
}

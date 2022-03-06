package com.example.android.localweatherwithfragment;

import static com.example.android.localweatherwithfragment.GetRetrofitObj.retrofitService;
import com.example.android.localweatherwithfragment.DataModel.Dto;
import io.reactivex.Observable;

public class DtoRepository {
    public static Observable<Dto> getDto(String cityName,
                                         String unitGroup,
                                         String include,
                                         String key,
                                         String contentType) {
        return retrofitService().getData(cityName, unitGroup, include, key,contentType);
    }
}
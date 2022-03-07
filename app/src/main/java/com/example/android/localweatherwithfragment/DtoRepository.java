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

        RequestParam param = new RequestParam(cityName,unitGroup,include,key,contentType);
        return retrofitService().getData(param.cityName, param.unitGroup, param.include, param.key,param.contentType);
    }
}
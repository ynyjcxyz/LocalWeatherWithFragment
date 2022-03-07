package com.example.android.localweatherwithfragment;

import static com.example.android.localweatherwithfragment.GetRetrofitObj.retrofitService;
import com.example.android.localweatherwithfragment.DataModel.Dto;
import io.reactivex.Observable;

public class DtoRepository {
    //p0 use RequestParam
    public static Observable<Dto> getDto(RequestParam param) {

        return retrofitService().getData(param.cityName, param.unitGroup, param.include, param.key,
            param.contentType,param.id);
    }
}
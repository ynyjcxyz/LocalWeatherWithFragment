package com.example.android.localweatherwithfragment;

import static com.example.android.localweatherwithfragment.GetRetrofitObj.retrofitService;
import com.example.android.localweatherwithfragment.DataModel.RawDto;
import io.reactivex.Observable;

public class DtoRepository {
    public static Observable<RawDto> getDto(RequestParam params) {
        return retrofitService()
                .getData(
                        params.cityName,
                        params.unitGroup,
                        params.key,
                        params.contentType);
    }
}
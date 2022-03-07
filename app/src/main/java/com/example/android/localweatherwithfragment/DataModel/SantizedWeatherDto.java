package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class SantizedWeatherDto implements Parcelable {

    @SerializedName("resolvedAddress")
    public abstract String resolvedAddress();

    @SerializedName("days")
    public abstract List<DaysBaseModel> weatherForecastList();

    @SerializedName("currentConditions")
    public abstract CurrentModel current_weather();

    public static SantizedWeatherDto create(String resolvedAddress,
        List<DaysBaseModel> weatherForecastList, CurrentModel current_weather) {
        return new AutoValue_SantizedWeatherDto(resolvedAddress, weatherForecastList,
            current_weather);
    }


}

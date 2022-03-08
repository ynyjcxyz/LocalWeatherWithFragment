package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class RawDto implements Parcelable {
    @SerializedName("resolvedAddress")
    public abstract String resolvedAddress();

    @SerializedName("days")
    public abstract List<DaysBaseModel> weatherForecastList();

    @SerializedName("currentConditions")
    public abstract CurrentModel current_weather();
}
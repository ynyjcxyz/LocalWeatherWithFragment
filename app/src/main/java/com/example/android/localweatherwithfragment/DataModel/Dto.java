package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class Dto implements Parcelable {

    @Nullable
    @SerializedName("resolvedAddress")
    public abstract String resolvedAddress();

    @Nullable
    @SerializedName("days")
    public abstract List<DaysBaseModel> weatherForecastList();

    @Nullable
    @SerializedName("currentConditions")
    public abstract CurrentModel current_weather();

}

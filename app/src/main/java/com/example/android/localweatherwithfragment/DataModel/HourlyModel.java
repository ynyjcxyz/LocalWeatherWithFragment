package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue

public abstract class HourlyModel implements Parcelable {
    @SerializedName("datetime")
    public abstract String datetime_hourly();

    @SerializedName("temp")
    public abstract double temp_hourly();

    @SerializedName("icon")
    public abstract String icon_hourly();
}

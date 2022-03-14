package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class DaysBaseModel implements Parcelable {

    @SerializedName("datetime")
    public abstract String datetime();

    @SerializedName("tempmax")
    public abstract double tempmax();

    @SerializedName("tempmin")
    public abstract double tempmin();

    @SerializedName("conditions")
    public abstract String conditions();

    @SerializedName("icon")
    public abstract String icon();

    @SerializedName("windspeed")
    public abstract double windspeed_daily();

    @SerializedName("humidity")
    public abstract double humidity_daily();

    @SerializedName("sunrise")
    public abstract String sunrise();

    @SerializedName("sunset")
    public abstract String sunset();
}

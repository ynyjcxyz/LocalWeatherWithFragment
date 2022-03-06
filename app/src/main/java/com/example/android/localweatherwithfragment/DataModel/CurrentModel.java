package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class CurrentModel implements Parcelable {

    @SerializedName("datetime")
    public abstract String datetime();

    @SerializedName("temp")
    public abstract double temp();

    @SerializedName("precip")
    public abstract double precip();

    @SerializedName("humidity")
    public abstract double humidity();

    @SerializedName("windspeed")
    public abstract double windspeed();

    @SerializedName("conditions")
    public abstract String conditions();

    @SerializedName("icon")
    public abstract String icon();

}

package com.example.android.localweatherwithfragment.DataModel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class HourlyModel implements Parcelable {

    @SerializedName("datetime")
    public abstract String datetime();


    @SerializedName("feelslike")
    public abstract double feelslike();

}
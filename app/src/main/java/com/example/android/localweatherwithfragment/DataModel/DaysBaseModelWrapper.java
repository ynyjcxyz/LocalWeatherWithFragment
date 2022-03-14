package com.example.android.localweatherwithfragment.DataModel;

public class DaysBaseModelWrapper {
    public final DaysBaseModel daysBaseModel;
    public boolean expanded;

    public DaysBaseModelWrapper(DaysBaseModel daysBaseModel, boolean expanded) {
        this.daysBaseModel = daysBaseModel;
        this.expanded = expanded;
    }

    public DaysBaseModel getDaysBaseModel() {
        return daysBaseModel;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}

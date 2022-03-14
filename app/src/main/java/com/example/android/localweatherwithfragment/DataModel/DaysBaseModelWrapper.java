package com.example.android.localweatherwithfragment.DataModel;

public class DaysBaseModelWrapper {
    private final DaysBaseModel daysBaseModel;
    private boolean expanded;

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

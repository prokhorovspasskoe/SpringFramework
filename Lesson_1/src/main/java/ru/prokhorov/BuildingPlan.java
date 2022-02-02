package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("BuildingPlan")
public class BuildingPlan implements Hospital{

    @Override
    public String getInformation() {
        return "Building plan";
    }
}
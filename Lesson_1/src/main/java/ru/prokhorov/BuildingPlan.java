package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("BuildingPlan")
public class BuildingPlan {

    public String getBuildingPlan() {
        return "building plan";
    }
}
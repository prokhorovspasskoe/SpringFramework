package ru.prokhorov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Registry")
public class Registry {
    private String buildingPlan = "";
    private String timeTable = "";
    private String archive = "";

    @Autowired
    @Qualifier("BuildingPlan")
    public void setBuildingPlan(Hospital buildingPlan) {
        this.buildingPlan = buildingPlan.getInformation();
    }

    @Autowired
    @Qualifier("Timetable")
    public void setTimeTable(Hospital timeTable) {
        this.timeTable = timeTable.getInformation();
    }

    @Autowired
    @Qualifier("Archive")
    public void setArchive(Hospital archive) {
        this.archive = archive.getInformation();
    }

    public void getTicket(){
        setBuildingPlan(new BuildingPlan());
        setArchive(new Archive());
        setTimeTable(new Timetable());
        if(!this.buildingPlan.isEmpty() && !this.timeTable.isEmpty() && !this.archive.isEmpty()){
            System.out.println("Направление выдано.");
        }else{
            System.out.println("Направление не выдано.");
        }
    }
}

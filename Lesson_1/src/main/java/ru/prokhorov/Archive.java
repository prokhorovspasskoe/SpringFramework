package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("Archive")
public class Archive {
    public String getPatientChart() {
        return "patient chart";
    }
}

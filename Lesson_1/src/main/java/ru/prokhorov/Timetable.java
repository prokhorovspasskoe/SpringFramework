package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("Timetable")
public class Timetable implements Hospital{

    @Override
    public String getInformation() {
        return "Timetable";
    }
}

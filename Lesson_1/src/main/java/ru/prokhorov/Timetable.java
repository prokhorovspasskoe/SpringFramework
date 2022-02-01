package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("Timetable")
public class Timetable {
    public String getTimeTable() {
        return "timetable";
    }
}

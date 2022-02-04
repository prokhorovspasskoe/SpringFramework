package ru.prokhorov;

import org.springframework.stereotype.Component;

@Component("Archive")
public class Archive implements Hospital{

    @Override
    public String getInformation() {
        return "Patient chart";
    }
}

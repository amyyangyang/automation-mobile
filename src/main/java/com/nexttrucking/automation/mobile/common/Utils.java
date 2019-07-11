package com.nexttrucking.automation.mobile.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class Utils {
    public static List<String> jobTypeList = new ArrayList<String>(asList("DROP & HOOK", "ROUNDTRIP", "MULTISTOP", "TEAM", "YARD TO YARD"));
    public static List<String> equipmentTypeList = new ArrayList<String>(asList("Flatbed", "Dry Van", "Power Only", "Reefer", "Box Truck"));

    public static boolean isInteger(String number) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(number).matches();
    }
}

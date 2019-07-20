package com.nexttrucking.automation.mobile.property;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class Utils {
    public static List<String> jobTypeList = new ArrayList<String>(asList("DROP & HOOK", "ROUNDTRIP", "MULTISTOP", "TEAM", "YARD TO YARD"));
    public static List<String> equipmentTypeList = new ArrayList<String>(asList("Flatbed", "Dry Van", "Power Only", "Reefer", "Box Truck"));
    public static List<String> jobStateList=new ArrayList<>(asList("ON WAY TO PICK UP","MISSING INVOICE","LOADED AT PICK UP","ARRIVED AT DROP OFF","ON WAY TO DROP OFF","MISSING POD","NO DRIVER ASSIGNED"));

    public static boolean isInteger(String number) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(number).matches();
    }
}

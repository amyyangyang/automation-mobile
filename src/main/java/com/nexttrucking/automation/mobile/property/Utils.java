package com.nexttrucking.automation.mobile.property;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class Utils {
    public static List<String> equipmentTypeListOnDetail = new ArrayList<String>(asList(" Dry Van","Power Only", "Reefer", "Box Truck"));
    public static List<String> jobTypeList = new ArrayList<String>(asList("DROP & HOOK", "ROUNDTRIP", "MULTISTOP", "TEAM", "YARD TO YARD"));
    public static List<String> equipmentTypeList = new ArrayList<String>(asList("ROUNDTRIP  |  DRY VAN","DROP & HOOK  |  POWER ONLY","ROUNDTRIP  |  POWER ONLY","MULTI-STOP  |  POWER ONLY","DROP & HOOK  |  DRY VAN","MULTI-STOP  |  DRY VAN","DRY VAN","POWER ONLY", "REEFER", "BOX TRUCK", "MULTI-STOP  |  POWER ONLY"));
    public static List<String> jobStateList=new ArrayList<>(asList("ON WAY TO PICK UP","MISSING INVOICE","LOADED AT PICK UP","ARRIVED AT DROP OFF","ON WAY TO DROP OFF","MISSING POD","NO DRIVER ASSIGNED"));
    public static List<String> paymentsStatusList = new ArrayList<String>(asList("CANCELED", "VERIFYING", "PAYMENT SENT"));
    public static List<String> liveUnloadJobStatus = new ArrayList<String>(asList("Loaded Container", "Empty Container"));

    public static boolean isInteger(String number) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(number).matches();
    }
}

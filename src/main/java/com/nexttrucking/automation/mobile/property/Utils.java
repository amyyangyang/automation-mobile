package com.nexttrucking.automation.mobile.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class Utils {
    public static List<String> equipmentTypeListOnDetail = new ArrayList<String>(asList("Dry Van", "Power Only", "Reefer", "Box Truck"));
    public static List<String> jobTypeList = new ArrayList<String>(asList("DROP & HOOK", "ROUNDTRIP", "MULTISTOP", "TEAM", "YARD TO YARD"));
    public static List<String> equipmentTypeList = new ArrayList<String>(asList("ROUNDTRIP  |  DRY VAN", "DROP & HOOK  |  POWER ONLY", "ROUNDTRIP  |  POWER ONLY", "MULTI-STOP  |  POWER ONLY", "DROP & HOOK  |  DRY VAN", "MULTI-STOP  |  DRY VAN", "DRY VAN", "POWER ONLY", "REEFER", "BOX TRUCK", "LOADSPEC.PORT  |  POWER ONLY", "MULTI-STOP  |  POWER ONLY", "DRAYAGE  |  POWER ONLY"));
    public static List<String> jobStateList = new ArrayList<>(asList("ON WAY TO PICK UP", "MISSING INVOICE", "LOADED AT PICK UP", "ARRIVED AT DROP OFF", "ON WAY TO DROP OFF", "MISSING POD", "NO DRIVER ASSIGNED"));
    public static List<String> paymentsStatusList = new ArrayList<String>(asList("CANCELED", "VERIFYING", "PAYMENT SENT"));
    public static List<String> liveUnloadJobStatus = new ArrayList<String>(asList("Loaded Container", "Empty Container"));
    public static List<String> paymentStatusList = new ArrayList<>(asList("VERIFYING","PAYMENT SENT, CANCELED"));

    public static boolean isInteger(String number) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(number).matches();
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String removeSpace(String str){
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        String strWithOutSpace = m.replaceAll("");
        return strWithOutSpace;
    }
}

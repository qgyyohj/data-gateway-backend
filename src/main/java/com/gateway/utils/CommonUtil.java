package com.gateway.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Z
 */
public class CommonUtil {

    public static List<String> strToList(String string){
        return Arrays.asList(string.substring(1,string.length()-1).split(", "));
    }
}

package com.sasanka.json;

import org.json.JSONArray;
import java.util.*;

public class CommonStringsFinder {

    public static void main(String[] args) {
        // Example JSONArray of JSONArrays with strings
        String jsonString = "[[\"apple\", \"orange\", \"banana\"], [\"banana\", \"pear\", \"apple\"], [\"apple\", \"banana\"]]";
        JSONArray jsonArray = new JSONArray(jsonString);

        // Find and print common strings
        Set<String> commonStrings = findCommonStrings(jsonArray);
        System.out.println("Common strings: " + commonStrings);
    }

    public static Set<String> findCommonStrings(JSONArray jsonArray) {
        // If the JSON array is empty, return an empty set
        if (jsonArray.length() == 0) {
            return Collections.emptySet();
        }

        // Initialize the set with the first JSONArray
        Set<String> commonSet = new HashSet<>(getStringList(jsonArray.getJSONArray(0)));

        // Iterate through the remaining JSONArrays
        for (int i = 1; i < jsonArray.length(); i++) {
            Set<String> currentSet = new HashSet<>(getStringList(jsonArray.getJSONArray(i)));
            // Retain only the strings that are common with the current JSONArray
            commonSet.retainAll(currentSet);
        }

        return commonSet;
    }

    private static List<String> getStringList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}

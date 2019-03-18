package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJSON = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<String>();
            if (alsoKnownAsJSON != null) {
                for (int i = 0; i < alsoKnownAsJSON.length(); i++) {
                    alsoKnownAs.add(alsoKnownAsJSON.getString(i));
                }
            }
            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            JSONArray ingredientsJSON = sandwich.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<String>();
            if (ingredientsJSON != null) {
                for (int i = 0; i < ingredientsJSON.length(); i++) {
                    ingredients.add(ingredientsJSON.getString(i));
                }
            }
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

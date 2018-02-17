package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        final String SND_NAME = "name";
        final String SND_MAINNAME = "mainName";
        final String SND_ALSOKNOWAS = "alsoKnownAs";
        final String SND_PLACE = "placeOfOrigin";
        final String SND_DESCRIPTION = "description";
        final String SND_IMAGE = "image";
        final String SND_INGREDIENTS = "ingredients";

        JSONObject sandwichJson = new JSONObject(json);

        Sandwich sandwich = new Sandwich();

        JSONObject nameObj = sandwichJson.getJSONObject(SND_NAME);
        sandwich.setMainName(nameObj.getString(SND_MAINNAME));

        JSONArray alsoKnowAsArray = nameObj.getJSONArray(SND_ALSOKNOWAS);
        List<String> alsoKnowAsList = new ArrayList<String>();
        for(int i=0; i < alsoKnowAsArray.length(); i++){
            alsoKnowAsList.add(alsoKnowAsArray.getString(i));
        }
        sandwich.setAlsoKnownAs(alsoKnowAsList);

        sandwich.setPlaceOfOrigin(sandwichJson.getString(SND_PLACE));

        sandwich.setDescription(sandwichJson.getString(SND_DESCRIPTION));

        sandwich.setImage(sandwichJson.getString(SND_IMAGE));

        JSONArray ingredientsArray = sandwichJson.getJSONArray(SND_INGREDIENTS);
        List<String> ingredientsList = new ArrayList<String>();
        for(int i=0; i < ingredientsArray.length(); i++){
            ingredientsList.add(ingredientsArray.getString(i));
        }
        sandwich.setIngredients(ingredientsList);


        return sandwich;

        //return null;
    }
}

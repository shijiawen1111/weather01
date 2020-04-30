package com.shijiawen.weather01.util;

import android.text.TextUtils;

import com.shijiawen.weather01.db.City;
import com.shijiawen.weather01.db.County;
import com.shijiawen.weather01.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//      json数据解析工具类
public class Utility {
    //      解析服务器返回的省级数据信息
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray();
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //    解析服务器返回的市级数据信息
    public static boolean handleCityResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCitys = new JSONArray(response);
                for (int i = 0; i < allCitys.length(); i++) {
                    JSONObject cityObject = allCitys.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //    解析服务器返回县级数据信息
    public static boolean handleCountyResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCountys = new JSONArray(response);
                for (int i = 0; i < allCountys.length(); i++) {
                    JSONObject countyObject = allCountys.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(countyObject.getInt("id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
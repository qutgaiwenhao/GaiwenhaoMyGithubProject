package com.sxl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Tianqi
{
  public static Map pachong(String jwd)
  {
    String url = "http://api.map.baidu.com/telematics/v3/weather?location=" + jwd + "&output=json&ak=Cut6TflRGQE9pzVqx21GA4ofRGELheES";
    
    Map map = new HashMap();
    try
    {
      Document doc = Jsoup.connect(url).ignoreContentType(true).data("query", "Java")
        .userAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)")
        .timeout(30000).get();
      String out = doc.body().text();
      JSONObject jo = JSONObject.parseObject(out);
      System.out.println("out===="+out);
      
      JSONArray joo = jo.getJSONArray("results");
      JSONObject jooo = joo.getJSONObject(0);
      String city = jooo.get("currentCity").toString();
      map.put("city", city);
      JSONArray joooo = (JSONArray)jooo.get("weather_data");
      System.out.println(joooo.get(0));
      
      JSONObject jooooo = (JSONObject)joooo.get(0);
      
      String wind = jooooo.getString("wind");
      String dayPictureUrl = jooooo.getString("dayPictureUrl");
      String weather = jooooo.getString("weather");
      String nightPictureUrl = jooooo.getString("nightPictureUrl");
      String date = jooooo.getString("date");
      String temperature = jooooo.getString("temperature");
      map.put("wind", wind);
      map.put("dayPictureUrl", dayPictureUrl);
      map.put("weather", weather);
      map.put("nightPictureUrl", nightPictureUrl);
      map.put("date", date);
      map.put("temperature", temperature);
      map.put("wind", wind);
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }
    return map;
  }
  
  public static void main(String[] args)
  {
    String jwd = "116.53075,39.915599";
    Map tq = pachong("http://api.map.baidu.com/telematics/v3/weather?location=" + jwd + "&output=json&ak=Cut6TflRGQE9pzVqx21GA4ofRGELheES");
  }
}
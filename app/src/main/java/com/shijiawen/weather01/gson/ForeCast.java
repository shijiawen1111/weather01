package com.shijiawen.weather01.gson;

import com.google.gson.annotations.SerializedName;

public class ForeCast {

    public String date;


    @SerializedName("tmp")
    public Tempereture tempereture;


    @SerializedName("cond")
    public More more;

    public class Tempereture {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}

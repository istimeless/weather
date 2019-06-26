package com.ls.weatherservice.constants;

/**
 * @author lijiayin
 */
public class Constant {
    
    public static class WeatherInfo{
        
        public static final String CACHE_PREFIX = "weather:";
        
        public static class WeatherNow {
            public static final String CACHE_PREFIX = "now:";
            public static final Integer CACHE_TIME = 30;
        }

        public static class WeatherDaily {
            public static final String CACHE_PREFIX = "daily:";
            public static final Integer CACHE_TIME = 30;
        }
    }
    
}

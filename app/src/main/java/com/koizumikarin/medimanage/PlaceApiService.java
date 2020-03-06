package com.koizumikarin.medimanage;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * URL Sample:
 * https://maps.googleapis.com/maps/api/place/search/json
 * ?types=cafe
 * &location=37.787930,-122.4074990
 * &radius=5000
 * &sensor=false
 * &key=YOUR_API_KEY
 */
public interface PlaceApiService {
    @Headers("Accept-Language: ja")
    @GET("/maps/api/place/search/json")
    Call<Response> requestPlaces(@Query("types") String types,
                                 @Query("location") String location,
                                 @Query("radius") String radius,
                                 @Query("sensor") String sensor,
                                 @Query("key") String key);
}
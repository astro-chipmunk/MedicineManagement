//package com.koizumikarin.medimanage;
//
//import android.content.Context;
//
//import com.google.android.gms.maps.model.LatLng;
//
//import retrofit.Call;
//import retrofit.Callback;
//import retrofit.GsonConverterFactory;
//import retrofit.Retrofit;
//
//public class PlacesApiHelper {
//    private static final String TAG = PlacesApiHelper.class.getSimpleName();
//    private final PlacesApiHelper self = this;
//
//    private Context mContext;
//
//    public PlacesApiHelper(Context context) {
//        mContext = context;
//    }
//
//    public void requestPlaces(String types, LatLng latLng, int radius, Callback<Response> callback) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(mContext.getString(R.string.places_api_url))
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        PlaceApiService service = retrofit.create(PlaceApiService.class);
//
//        Call<Response> call = service.requestPlaces(types,
//                String.valueOf(latLng.latitude) + "," + String.valueOf(latLng.longitude),
//                String.valueOf(radius),
//                "false",
//                mContext.getString(R.string.google_maps_key_browser));
//        call.enqueue(callback);
//    }
//}
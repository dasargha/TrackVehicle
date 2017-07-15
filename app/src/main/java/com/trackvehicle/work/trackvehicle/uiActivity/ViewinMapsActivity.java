package com.trackvehicle.work.trackvehicle.uiActivity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.trackvehicle.work.trackvehicle.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import application.ApplicationController;
import asyncTaskController.AsyncPostRequestHandler;
import utils.AppConstants;
import viewModal.BaseResponse;
import viewModal.LocationInfoResonse;

public class ViewinMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker nmarker;
    private float zoomlevel = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewin_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getInfoFromUrl();
            }
        },5000);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getInfoFromUrl();
        LatLng sydney = new LatLng(-34, 151);

        placeMarker(mMap , sydney);

    }


    private void getInfoFromUrl() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConstants.GET_LOCATION_INFO, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", "Response " + response);
               /* GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                BaseResponse mBaseResponse = mGson.fromJson(response, BaseResponse.class);*/
               try {
                   JSONObject mjson = new JSONObject(response);
                   JSONObject locObject = mjson.getJSONObject("result");
                   locObject.getString("latitude");
                   LatLng nowLocation = new LatLng(Double.parseDouble(locObject.getString("latitude")),
                           Double.parseDouble(locObject.getString("longitude")));
                   if(mMap!=null)
                       placeMarker(mMap , nowLocation);
               }catch (Exception e){
                   Log.d("Response", "Response " + e.getMessage());
               }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Error " + error.getMessage());
            }
        });
        ApplicationController.getInstance().addToRequestQueue(stringRequest);
    }

    private void placeMarker(GoogleMap mMap, LatLng currLatLng) {

        // Add a marker in Sydney and move the camera
        if(nmarker!=null)
            nmarker.remove();
        nmarker = mMap.addMarker(new MarkerOptions().position(currLatLng).title("Moving device").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.setMinZoomPreference(zoomlevel);
       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currLatLng,zoomlevel));
    }


}

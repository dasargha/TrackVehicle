package asyncTaskController;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import application.ApplicationController;
import utils.AppConstants;

/**
 * Created by Argha on 24-Jun-17.
 */

public class AsyncPostRequestHandler {

    public static JsonObjectRequest sendPostData(final JSONObject  params ) {

        // Post params to be sent to the server

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST,AppConstants.LOCATION_POST_URL,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(ApplicationController.getInstance(),  "success"+response.toString(), Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ApplicationController.getInstance(),  error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        return jsObjRequest;
    }

}

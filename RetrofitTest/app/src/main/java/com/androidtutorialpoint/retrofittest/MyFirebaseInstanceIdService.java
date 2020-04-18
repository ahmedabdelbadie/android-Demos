package com.androidtutorialpoint.retrofittest;
import com.google.firebase.iid.FirebaseInstanceId ;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Ahmed on 2/21/2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshtoken = FirebaseInstanceId.getInstance().getToken();
    }
}

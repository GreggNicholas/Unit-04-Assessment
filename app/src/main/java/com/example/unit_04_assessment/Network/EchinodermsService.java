package com.example.unit_04_assessment.Network;

import com.example.unit_04_assessment.Model.EchinodermArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EchinodermsService {

    @GET("/JDVila/storybook/master/echinoderms.json")
    Call<EchinodermArrayList> getEchinodermsList();
}

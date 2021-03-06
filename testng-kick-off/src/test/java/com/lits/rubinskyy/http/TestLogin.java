package com.lits.rubinskyy.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

public class TestLogin {
    @Test
    public void testLogin() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request postLogin = new Request.Builder()
                .url("https://europe-west2-search-app-263e2.cloudfunctions.net/webapp/api/auth/login")
                .post(RequestBody.create(MediaType.parse("application/json"), "{\n" +
                        "\t\"email\":\"rubins.yurko.test@gmail.com\",\n" +
                        "\t\"password\":\"Test1234!\"\n" +
                        "}")).build();

        Response execute = client.newCall(postLogin).execute();
        String body = execute.body().string();

        //System.out.println(execute.body().string());
        ResponseHandleLogin responseHandleLogin = new ResponseHandleLogin();
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ResponseHandleLogin.R r = objectMapper.readValue(body, ResponseHandleLogin.R.class);
        System.out.println(r.toString());
    }
}

package services;

import entity.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @POST("auth/signin")
    @Headers("Content-Type: application/json")
    Call<UserLogin> Post_Login(@Body UserLogin login);
}

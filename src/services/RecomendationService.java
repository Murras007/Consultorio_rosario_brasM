package services;

import entity.Recomendation;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RecomendationService {

    @GET("recomendation")
    Call<List<Recomendation>>findAll();

    @POST("{id}/recomendation")
    Call<Recomendation>addRecomendation(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body Recomendation recomendation);
}

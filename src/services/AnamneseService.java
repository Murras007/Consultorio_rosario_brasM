package services;

import entity.Anamnese;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AnamneseService {
    @GET("anamnese")
    Call<List<Anamnese>>findAll();

    @POST("{id}/anamnese")
    Call<Anamnese>add(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body Anamnese anamnese);
}

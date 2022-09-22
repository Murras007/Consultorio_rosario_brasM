package services;

import entity.Treatment;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TreatmentService {

    @GET("treatment")
    Call<List<Treatment>>findAll();

    @POST("{id}/treatment")
    Call<Treatment>addTreatment(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body Treatment treatment);
}

package services;

import entity.Consultation;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ConsultationService {

    @GET("/consultation")
    Call<List<Consultation>> findAll();

    @GET("{id}/consultation")
    Call<Consultation>findById(@Header("cookie")String sessionIdAndToken,@Path("id") int id);

    @POST("{id}/consultation")
    Call<Consultation> addConsultation(@Header("cookie") String sessionIdAndToken, @Path("id") int id,@Body Consultation consultation);
}

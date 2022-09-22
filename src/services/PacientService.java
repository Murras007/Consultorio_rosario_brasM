package services;

import entity.Pacient;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PacientService {

    @GET("pacient")
    Call <List<Pacient>>findAll(@Header("cookie") String sessionIdAndToken);

    @GET("{id}/pacient")
    Call<Pacient>findById(@Path(value = "id")int id, @Header("cookie")String sessionIdAndToken);


    @POST("{Id}/pacient")
    Call <Pacient> addPacient(@Header("cookie") String sessionIdAndToken,@Path("Id") int id, @Body Pacient pacient);

    @PUT("{Id}/pacient")
    Call<Pacient> editPacient(@Header("cookie") String sessionIdAndToken,@Path("Id") int id, @Body Pacient pacient);

    @DELETE("{Id}/pacient")
    Call<Pacient>deletePacient(@Header("cookie") String sessionIdAndToken,@Path("Id") int id);
}

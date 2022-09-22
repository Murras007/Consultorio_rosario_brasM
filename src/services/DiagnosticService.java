package services;

import entity.Diagnostic;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DiagnosticService {

    @GET("diagnostic")
    Call<List<Diagnostic>>findAll();

    @POST("{id}/diagnostic")
    Call<Diagnostic>addDiagnostic(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body Diagnostic diagnostic);
}

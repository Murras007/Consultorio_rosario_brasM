package services;

import entity.ComplementaryExams;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ComplementaryExamsService {
    @GET("compExams")
    Call<List<ComplementaryExams>>findAll();

    @POST("{id}/compExams")
    Call<ComplementaryExams>addCompExams(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body ComplementaryExams complementaryExams);
}

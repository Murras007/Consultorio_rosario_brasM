package services;

import entity.ObjectiveExams;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ObjectiveExamsService {

    @GET("objectiveExams")
    Call<List<ObjectiveExams>>findAll();

    @POST("{id}/objectiveExams")
    Call<ObjectiveExams>addObjectiveExams(@Header("cookie") String sessionIdAndToken, @Path("id") int id, @Body ObjectiveExams objectiveExams);
}

package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Consultation {

    private int id;


    private String consultation;

    @Expose
    @SerializedName("currentDate")
    private String CurrentDate;

    @Expose
    @SerializedName("editDate")
    private String EditDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsultation() {
        return consultation;
    }

    private List<ObjectiveExams>objectiveExams;

    private List<Recomendation>recomendations;

    private List<Diagnostic>diagnostics;

    private List<ComplementaryExams>complementaryExams;

    private List<Anamnese>anamneses;

    private List<Treatment>treatments;


    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }

    public String getEditDate() {
        return EditDate;
    }

    public void setEditDate(String editDate) {
        EditDate = editDate;
    }

    public List<ObjectiveExams> getObjectiveExams() {
        return objectiveExams;
    }

    public void setObjectiveExams(List<ObjectiveExams> objectiveExams) {
        this.objectiveExams = objectiveExams;
    }

    public List<Recomendation> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recomendation> recomendations) {
        this.recomendations = recomendations;
    }


    public List<Diagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(List<Diagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }

    public List<ComplementaryExams> getComplementaryExams() {
        return complementaryExams;
    }

    public void setComplementaryExams(List<ComplementaryExams> complementaryExams) {
        this.complementaryExams = complementaryExams;
    }

    public List<Anamnese> getAnamneses() {
        return anamneses;
    }

    public void setAnamneses(List<Anamnese> anamneses) {
        this.anamneses = anamneses;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}

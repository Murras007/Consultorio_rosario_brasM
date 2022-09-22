package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pacient implements Serializable {
    private int id;
    private String name;

    private String age;
    @Expose
    @SerializedName("profession")
    private String profission;
    @Expose
    @SerializedName("bookingDate")
    private String BookingDate;

    private String phone;
    @Expose
    @SerializedName("b_I")
    private String BI;
    @Expose
    @SerializedName("dateOfBirth")

    private String DateOfBirth;
    private String MedicalAID;
    @Expose
    @SerializedName("address")
    private String Address;
    @Expose
    @SerializedName("currentDate")
    private String CurrentDate;
    @Expose
    @SerializedName("editDate")
    private String EditDate;

    public List<ObjectiveExams> objectiveExams;
    public List<Recomendation> recomendations;
   // public ArrayList<HistoryDisease> history_diseases;
    public List<Diagnostic> diagnostics;
    public List<ComplementaryExams> complementaryExams;
    public List<Anamnese> anamneses;

    public List<Consultation>consultations;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfission() {
        return profission;
    }

    public void setProfission(String profission) {
        this.profission = profission;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getMedicalAID() {
        return MedicalAID;
    }

    public void setMedicalAID(String medicalAID) {
        MedicalAID = medicalAID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public List<Consultation> getConsultations() {
        return consultations;
    }
}

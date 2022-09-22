package entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjectiveExams implements Serializable {
    private int id;

    @Expose
    @SerializedName("weight")
    private double Weight;


    private double height;


    private int bloodPressure;


    private double temperature;


    private String head;


    private String neck;


    private String chest;


    private String lungExam;


    private String ascultacao;


    private String cardiacExam;


    private String abdomen;


    private String genitals;


    private String recto;


    private String limbs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getLungExam() {
        return lungExam;
    }

    public void setLungExam(String lungExam) {
        this.lungExam = lungExam;
    }

    public String getAscultacao() {
        return ascultacao;
    }

    public void setAscultacao(String ascultacao) {
        this.ascultacao = ascultacao;
    }

    public String getCardiacExam() {
        return cardiacExam;
    }

    public void setCardiacExam(String cardiacExam) {
        this.cardiacExam = cardiacExam;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getGenitals() {
        return genitals;
    }

    public void setGenitals(String genitals) {
        this.genitals = genitals;
    }

    public String getRecto() {
        return recto;
    }

    public void setRecto(String recto) {
        this.recto = recto;
    }

    public String getLimbs() {
        return limbs;
    }

    public void setLimbs(String limbs) {
        this.limbs = limbs;
    }
}

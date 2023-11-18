package Iteration2.Implementation;

public class Temperature {

    //Attributes
    private float value;
    private String unit;


    //Constructor
    public Temperature(float value, String unit){
        this.value = value;
        this.unit = unit;
    }

    //Getter and setter methods
    public void setValue(float value){
        this.value = value;
    }
    public float getValue(){
        return value;
    }
    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%.02f", value) + unit ;
    }
}

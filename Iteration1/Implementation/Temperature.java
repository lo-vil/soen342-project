package Iteration1.Implementation;

public class Temperature {

    //Attributes
    private float value;
    private String unit;


    //Methods
    public Temperature(float value, String unit){
        this.value = value;
        this.unit = unit;
    }

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

}

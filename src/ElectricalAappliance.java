public class ElectricalAappliance {

    int chargeLevel;
    boolean switchedOn;

    public void turnOn() {
        this.switchedOn = true;
    }
    public void turnOff() {
        this.switchedOn = false;
    }

    public boolean switchedOn(){
        return this.switchedOn;
    }
    public void addCharge(){
        this.chargeLevel = this.chargeLevel+1;
    }
    public int getChargeLevel(){
        return this.chargeLevel;
    }

}

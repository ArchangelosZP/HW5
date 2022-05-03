public class MobilePhone extends ElectricalAappliance {
    @Override
    public void addCharge(){
        this.chargeLevel = this.chargeLevel+2;
    }
}

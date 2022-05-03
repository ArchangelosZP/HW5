import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ScriptException {
       Calc calcObj = new Calc();
       if (calcObj.switchedOn) {
           if (calcObj.chargeLevel <2) { // It would be nice to recharge a little
               for (;calcObj.chargeLevel <10;){
               calcObj.addCharge();}
           }
           calcObj.calcM();
       }
       else{
           calcObj.turnOn();
           calcObj.calcM();
       }
        sArray();
    }
        public static void sArray() {
            int[] arr = {2, 1, 1, 1, 2};
            int[] arrS = new int[arr.length];
            arrS[0] = arr[0];
            for (int i = 1; i < arr.length; i++)
                arrS[i] = arrS[i - 1] + arr[i];
            System.out.println("Input array:" + Arrays.toString(arr));
            System.out.println("Output array:" + Arrays.toString(arrS));
        }

    }



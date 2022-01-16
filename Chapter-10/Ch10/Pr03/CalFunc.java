package Ch10.Pr03;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class CalFunc {
    static final int SCALE_BIGDECIMAL = 16;
    static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;
    static Boolean isEntry = true;
    static BigDecimal num1 = BigDecimal.ZERO;
    static BigDecimal num2 = BigDecimal.ZERO;
    static BigDecimal result;
    static int first_arith;
    static int second_arith;
    static byte status;

    /*
    *    "status" indicates how to take user's input numbers and operations.
    *    The program should consider the order of the input numbers,
    *    Four arithmetic operations (+, -, *, /) and equal operation (=) which confirm result even while calculating,
    *    Other operations affecting only field number,
    *    Entry to check if the field is able to get backspace editing, or just initiate the field numbers,
    *    And so on.
    */

    static void Functions(int index){
        switch(index){
            case 0:
                Backspace();
                break;
            case 1:
                CE();
                break;
            case 2:
                C();
                break;
        }
    }
    static void Memories(int index) {
        switch (index) {
            case 0:
                MC();
                break;
            case 1:
                MR();
                break;
            case 2:
                MS();
                break;
            case 3:
                Mplus();
                break;
        }
        if(SwingCalculator.mem.compareTo(BigDecimal.ZERO) != 0)
            SwingCalculator.blank.setText("M");
        else
            SwingCalculator.blank.setText(" ");
    }
    static void Numbers(int num){
        if(getField().equals("0"))
            updateField(Integer.toString(num));
        else
            if(isEntry)
                updateField(getField() + Integer.toString(num));
            else
                updateField(Integer.toString(num));
        if((status & 15) == 0b0001)
            status = 0;
        if((status & 15) == 0b0011)
            status |= 0b100;
        isEntry = true;
    }
    static void Arithmetics(int index){
        try{
            if(index < 0 || index > 9)
                throw new Exception();
        switch(index) {
            case 0:
                negative();
                break;
            case 1:
                dot();
                break;
            case 3:
                Equal();
                break;
            default:
                Operations(index);
                break;
            }
        } catch(Exception e){}
    }
    static void Backspace(){
        if(!isEntry)
            return;
        String str = getField();
        if(str.length() <= 1)
            updateField("0");
        else
            updateField(str.substring(0, str.length()-1));
    }
    static void CE(){
        updateField("0");
        if(!isEntry)
            result = BigDecimal.ZERO;
        if(status < 0b0010) {
            num1 = BigDecimal.ZERO;
            status = 0b0001;
        }
        else {
            num2 = BigDecimal.ZERO;
            status = 0b0111;
        }
        isEntry = true;
    }
    static void C(){
        isEntry = true;
        num1 = BigDecimal.ZERO;
        num2 = BigDecimal.ZERO;
        result = BigDecimal.ZERO;
        first_arith = 0;
        second_arith = 0;
        status = 0;
        updateField("0");
    }
    static void MC(){
        updateMemory(BigDecimal.ZERO);
        isEntry = false;
    }
    static void MR(){
        BigDecimal mem = SwingCalculator.mem;
        updateField(mem);
        result = mem;
        isEntry = false;
    }
    static void MS(){
        updateMemory(getField());
        isEntry = false;
    }
    static void Mplus(){
        updateMemory(SwingCalculator.mem.add(new BigDecimal(getField())) );
    }
    static void negative(){
        updateField(new BigDecimal(getField()).multiply(new BigDecimal(-1)));
    }
    static void dot(){
        if(isEntry)
            if(!getField().contains("."))
                updateField(getField() + ".");
        else
            updateField("0.");
    }
    static void Operations(int index){
        {
            if((status | 1) == 0b0001){
                num1 = new BigDecimal(getField());
                status |= 0b0001;
            }
            if((status | 2) == 0b0011){
                if(index % 2 == 0) {
                    first_arith = index;
                    status |= 0b0010;
                }
                else
                    if(status < 2)
                        ArithSpecialOperations(num1, index);
                    else
                        ArithSpecialOperations(num2=num1, index);
            }
            if((status & 15) == 0b0111){
                num2 = new BigDecimal(getField());
                if(index % 2 == 0) {
                    second_arith = index;
                    status |= 0b1000;
                }
                else
                    ArithSpecialOperations(num2, index);
            }
            if(status == 15){
                ArithOperations(first_arith);
                num1 = result;
                first_arith = second_arith;
                status = 0b0011;
            }
        }
        isEntry = false;
    }
    static void ArithOperations(int arith){
        switch(arith){
            case 2:
                result = num1.add(num2);
                break;
            case 4:
                result = num1.subtract(num2);
                break;
            case 6:
                result = num1.multiply(num2);
                break;
            case 8:
                if(num2.compareTo(BigDecimal.ZERO) == 0){
                    C();
                    updateField("0으로 나눌 수 없습니다");
                    return;
                }
                result = num1.divide(num2, MATH_CONTEXT);
                break;
        }
        updateField(result);
    }
    static void ArithSpecialOperations(BigDecimal num, int arith){
        switch(arith){
            case 5:
                if(num.compareTo(BigDecimal.ZERO) == 0){
                    C();
                    updateField("0으로 나눌 수 없습니다");
                    return;
                }
                num = BigDecimal.ONE.divide(num, MATH_CONTEXT);
                break;
            case 7:
                num = num1.multiply(num2).divide(new BigDecimal(100), MATH_CONTEXT);
                break;
            case 9:
                // Cannot use BigDecimal.sqrt() directly since it is supported since SE9...
                num = new BigDecimal(Double.toString(Math.sqrt(num.doubleValue())));
                break;
        }
        updateField(num);
    }
    static void Equal(){
        {
            if((status | 1) == 0b0001){
                num1 = new BigDecimal(getField());
                result = num1;
                status |= 0b0001;
            }
            if((status | 2) == 0b0011){
                result = num1;
                if(status > 2)
                    num2 = result;
                ArithOperations(first_arith);
                status = 0b0001;
            }
            if((status & 15) == 0b0111){
                num2 = new BigDecimal(getField());
                status |= 0b1000;
            }
            if(status == 15){
                ArithOperations(first_arith);
                num1 = result;
                status = 0b0001;
            }
        }
        isEntry = false;
    }
    static String getField(){
        return SwingCalculator.field.getText();
    }
    static void updateField(String str){
        SwingCalculator.field.setText(str);
    }
    static void updateField(BigDecimal f){
        if(f.compareTo(f.setScale(0, RoundingMode.HALF_UP)) == 0)
            SwingCalculator.field.setText(f.toBigInteger().toString());
        else
            SwingCalculator.field.setText(f.setScale(SCALE_BIGDECIMAL, RoundingMode.HALF_UP).stripTrailingZeros().toString());
    }
    static void updateMemory(String str){ SwingCalculator.mem = new BigDecimal(str); }
    static void updateMemory(BigDecimal f){
        SwingCalculator.mem = f;
    }
}

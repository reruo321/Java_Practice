public class Ch04Ex05Break {
    public static void main(String [] args){

       iloop: for(int i=1; i <= 5; i+=2){

        jloop:    for(int j=2; j <= 6; j+=2){
                    if (i == 3)
                    //    break jloop;
                        break iloop;
                    System.out.println("i( " + i + " ),   j( " + j + " )");
            }
        }


    }
}

package Ch06.Ex08;

import java.util.Scanner;

public class Test {
    public static void main(String [] args){

        final int n = Integer.parseInt(args[0]);
        Scanner scan = new Scanner(System.in);
        Employee [] emp = new Employee[n];
        Staff sf;
        RegEmployee rg;
        TempEmployee tp;
        String no, name;
        System.out.println("입력 자료수: " + n);
        for(int i=0; i<n; i++){
            System.out.print("\n사원번호, 이름..");
            no = scan.next();
            name = scan.next();
            System.out.print("사원의 근무유형: (1:CEO, 2:정규직, 3:임시직)..");
            int kind = scan.nextInt();
            switch(kind){
                case 1: System.out.print("직책, 월입금..");
                        String title = scan.next();
                        long staffpay = scan.nextLong();
                        sf = new Staff(name, no, title, staffpay);
                        emp[i] = sf;
                        break;
                case 2: System.out.print("부서, 업무, 월임금..");
                        String dept = scan.next();
                        String regtitle = scan.next();
                        long regpay = scan.nextLong();
                        rg = new RegEmployee(name, no, dept, regpay, regtitle);
                        emp[i] = rg;
                        break;
                case 3: System.out.print("부서, 월근무시간수..");
                        String hdept = scan.next();
                        long temphour = scan.nextLong();
                        tp = new TempEmployee(name, no, hdept, temphour);
                        emp[i] = tp;
                        break;
                default: System.out.println("근무유형 오류 재입력..");
            }
        }
        System.out.println("\n          급여보고서");
        for(Employee e: emp)
            System.out.println(e + "급여액: " + e.earnings());
    }
}

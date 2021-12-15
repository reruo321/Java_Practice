package Ch06.Pr01;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public final class VideoStore {
    public Inventory inventory;
    public Customer [] customerList;
    public VideoStore(Video [] videoList){
        inventory = new Inventory(videoList);
        customerList = new Customer[0];
    }
    public String rent(){
        Scanner scan = new Scanner(System.in);
        System.out.print("성명을 입력하십시오. 입력을 끝내려면 Q를 입력하십시오. ");
        String name = scan.next();
        scan.nextLine();
        if(name.equals("Q"))
            return "END";
        int num = -1;

        for (int i = 0; i < customerList.length; i++) {   // Check customer's information
            if (customerList[i].name.equals(name)) {   // Suppose that there is no duplicated customer name.
                num = i;
                break;
            }
        }

        if (num < 0) {   // Register the new customer
            Customer [] new_customerList = Arrays.copyOf(customerList, customerList.length + 1);
            System.out.println("고객님을 새로 등록합니다. 주소를 입력하십시오. ");
            String address = scan.nextLine();
            System.out.println("전화번호를 입력하십시오. ");
            String tel = scan.nextLine();
            while(true) {
                System.out.print("고객님은 어린이입니까? (예/아니요) ");
                String yn = scan.next();
                if (yn.equals("예")) {
                    new_customerList[customerList.length] = new Child(name, address, tel);
                    break;
                    }
                else if (yn.equals("아니요")) {
                    new_customerList[customerList.length] = new Adult(name, address, tel);
                    break;
                    }
                else
                    System.out.println("예/아니요 중 하나를 입력하십시오.");
                }
            num = customerList.length;
            customerList = new_customerList;
            customerList[num].rentalList = new Rental[0];
        }

        int videonum;

        while(true) {
            System.out.println("\n----- 대여 가능한 비디오 목록 -----");
            for(Video v : inventory.videoList) {
                System.out.println("제목: " + v.title + ", 대여료: " + v.charge + ", 분류: " + v.category);
            }

            while (true) {
                System.out.print("\n빌릴 비디오의 개수를 입력하십시오. ");
                videonum = scan.nextInt();
                scan.nextLine();
                if (videonum > 0)
                    break;
                System.out.println("비디오 개수는 1 이상 숫자로 입력하십시오.");
            }
            String[] title = new String[videonum];
            for (int a = 0; a < videonum; a++) {
                System.out.print("빌릴 비디오의 제목을 입력하십시오. ");
                title[a] = scan.nextLine();
            }

            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
            customerList[num].rentalList = Arrays.copyOf(customerList[num].rentalList, customerList[num].rentalList.length + 1);
            customerList[num].rentalList[customerList[num].rentalList.length - 1] = new Rental(format.format(today));

            for (String t : title) {
                if (!inventory.rent(t).equals("")) {   // if the video exists
                    Video findingVid = inventory.videoList[Integer.parseInt(inventory.rent(t))];
                    customerList[num].rentalList[customerList[num].rentalList.length - 1].add(findingVid);
                }
            }
            if (customerList[num].rentalList[customerList[num].rentalList.length - 1].videoList.length < 1)   // Failed to rent anything
                System.out.println("비디오를 하나도 대여하지 못했습니다. 제목을 확인한 뒤 다시 신청하십시오.");
            else if (customerList[num].rentalList[customerList[num].rentalList.length - 1].videoList.length < videonum)   // Some rentals are failed
                System.out.println((videonum - customerList[num].rentalList[customerList[num].rentalList.length - 1].videoList.length) + "개의 비디오를 빌리지 못 하였습니다. 추가 대여를 희망하면 대여신청을 다시하고 제목을 올바르게 입력하십시오.");
            break;
        }
        System.out.println("---------- 대여 현황 ----------");
        for(Customer c : customerList) {
            String str = c.toString();
            for (Rental r : c.rentalList) {
                str += "-- 날짜: " + r.date + ", 대여료 합계: " + r.price + "원\n";
                for (Video v : r.videoList)
                    str += "제목: " + v.title + ", 대여료: " + v.charge + "원, 분류: " + v.category + "\n";
            }
            System.out.println(str);
        }
        return "";
    }
}

package model;

import java.util.Scanner;

public class NhanVienWIPModel {


    public int checkInputNumberStatus(Scanner sc){
        int choose;
        try {
            choose = Integer.parseInt(sc.nextLine());
        }catch (Exception ex){
            System.out.println("Nhập Không đúng. Vui lòng nhập 1~3");
            return checkInputNumberStatus(sc);
        }
        return choose;
    }

    public Status checkStatus(Scanner sc){
        int choose = checkInputNumberStatus(sc);
        Status status = null;
        if (choose == 0 && choose > 3 ){
            System.out.println("Chọn sai. Vui lòng chọn 1. PENDING , 2. DONE , 3. PROCESS");
            return checkStatus(sc);
        }
        switch (choose){
            case 1:
                status = Status.PENDING;
                break;
            case 2:
                status = Status.DONE;
                break;
            case 3:
                status = Status.PROCESS;
                break;
        }
        return status;
    }
}

package services;

import utils.InputValue;

public class ReceptionistService implements IService{



    public void showFunction() {
        while (true){
            System.out.println("1. Nhập thông tin khách hàng");
            System.out.println("2. Nhập thông tin sản phẩm");
            System.out.println("3. Sửa Thông tin khách hàng");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Tạo hóa đơn");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 5);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    showAddCustomer();
                    break;
                case 2:
                    showAddProduct();
                    break;
                case 3:
                    showChangeCustomer();
                    break;
                case 4:
                    showChangeProduct();
                    break;
                case 5:
                    showInvoice();
                    break;
            }
        }

    }

    private void showChangeProduct() {
        //
    }

    private void showChangeCustomer() {
        //
    }

    private void showAddProduct() {
        while (true){
            System.out.println("1. Thay đổi ID sản phẩm");
            System.out.println("2. Thay đổi tên Model");
            System.out.println("3. Thay đổi tên lỗi");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }
    }

    private void showInvoice() {
        //
    }

    private void showAddCustomer() {
        while (true){
            System.out.println("1. Thay đổi ID khách hàng");
            System.out.println("2. Thay đổi tên khách hàng");
            System.out.println("3. Thay đổi địa chỉ khách hàng");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0 ){
                break;
            }
            switch (choose){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }


    public void detelet() {

    }


    public void showAdd() {

    }
}

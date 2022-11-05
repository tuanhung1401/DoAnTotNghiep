package validation;

import model.Account;
import model.Employee;
import services.AdminService;



public class Authorization {
    AdminService adminService = new AdminService();

    public void authorize(Account acc) {
        switch (acc.getType()) {
            case ADMIN:
                adminService.showFunction();
                break;
            case QUANLY:
                //
                break;
            case NHANVIENSUAFONT:
                //
                break;
            case NHANVIENSUAPCB:
                //
                break;
            case NHANVIENSUAPHANMEM:
                //
                break;
            case NHANVIENWIP:
                //
                break;
            case NHANVIENKHO:
                //
                break;
        }
    }


}

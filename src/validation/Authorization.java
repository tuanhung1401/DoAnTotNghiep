package validation;

import model.Account;
import model.Employee;
import model.Material;
import services.AdminService;
import services.MaterialSercive;


public class Authorization {
    AdminService adminService = new AdminService();
    MaterialSercive materialSercive = new MaterialSercive();
    // phân quyền login
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
                materialSercive.showFunction();
                break;
        }
    }


}

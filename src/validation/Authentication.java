package validation;

import database.DataBase;
import model.Account;
import model.Employee;

import java.util.List;

public class Authentication {
    // check tài khoản và mk trùng không
    public Account login(String account, String password) {
        for (Account acc : DataBase.accountsList) {
            if (acc.getUserName().equals(account) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }
}

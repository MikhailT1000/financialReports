package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.PassportVerificationService;

@Service
@Qualifier("staff")
public class StaffVerificationService implements PassportVerificationService {
    @Override
    public boolean isValid(String name, String passport) {
        return name.equals("user1") && passport.equals("0000-11111");
    }
}
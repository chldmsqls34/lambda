package com.linus.api.kaup;


import com.linus.api.user.User;

public interface KaupService {
    public double createBMI(User user);
    public String creatBodyMass(double bmi);

}

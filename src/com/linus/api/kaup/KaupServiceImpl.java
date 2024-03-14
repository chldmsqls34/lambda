package com.linus.api.kaup;



import com.linus.api.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KaupServiceImpl implements KaupService {
    private static KaupService instance = new KaupServiceImpl();

    Map<?,?> kaupMap;
    List<? extends User> kaupList;

    private KaupServiceImpl(){
        this.kaupMap = new HashMap<>();
        this.kaupList = new ArrayList<>();
    }
    public static KaupService getInstance(){
        return instance;
    }
    @Override
    public double createBMI(User user) {
        double height = user.getHeight();
        double weight = user.getWeight();
        return weight/Math.pow(height/100,2);

    }

    @Override
    public String creatBodyMass(double bmi) {
       String result ="";
            if(bmi<18.5){
                result = "저체중";
            } else if(bmi<25){
                result = "정상체중";
            } else if(bmi<30){
                result = "과체중";
            } else {
                result = "비만";
            }
        return result;
    }

}


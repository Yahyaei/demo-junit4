package com.example.demojunit4;

public class ConOfAge {
    public boolean isAllowedToEnterLiquorStore(int age, boolean inCompanyOfAParent, boolean hasADog, boolean isBlind) {
        if(!isBlind && hasADog){
            return false;
        }
        if(!inCompanyOfAParent && age < 20){
            return false;
        }
        return true;
    }


}

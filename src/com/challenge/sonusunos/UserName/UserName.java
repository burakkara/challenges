package com.challenge.sonusunos.UserName;

/**
 * Created by karab on 22/12/14.
 */
import java.util.*;

/*
Problem Name:	UserName
Used In:	SRM 203
Used As:	Division II Level One
Categories:	Simple Search, Iteration, String Manipulation
*/

public class UserName{

    public String newMember(String [] existingNames, String newName){

        Set<String> set = new HashSet<String>();
        for(String name : existingNames){
            set.add(name);
        }
        if(set.contains(newName)){
            return checkSetForName(set, newName, 1);
        }else {
            return newName;
        }
    }

    public String checkSetForName(Set<String> set, String newName, int i){
        String temp;
        if(set.contains(newName + i)){
            return checkSetForName(set, newName, ++i);
        } else {
            return newName+i;
        }
    }

}
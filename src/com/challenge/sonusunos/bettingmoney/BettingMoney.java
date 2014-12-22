package com.challenge.sonusunos.bettingmoney;

/**
 * Created by karab on 22/12/14.
 */

/*
Problem Name:	BettingMoney
Used In:	SRM 191
Used As:	Division II Level One
Categories:	Simple Math, Simulation
*/
public class BettingMoney{

    public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult){
        int totalGain = 0, totalLoss;
        for(int i = 0; i < amounts.length; i++){
            if ( i!= finalResult )
                totalGain+=amounts[i];
        }
        totalLoss = amounts[finalResult]*centsPerDollar[finalResult];
        return 100 * totalGain - totalLoss;
    }
}
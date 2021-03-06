package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Wares;

import java.util.ArrayList;
import java.util.List;

public class Order{
    Cashier cashier;

    public Order(Cashier cashier){
        this.cashier = cashier;
    }

    public void announce() {
        this.cashier.publish(this.cashier.getName() + " the Cashier checks to see if games need to be restocked...");
    }

    public void doAction(Wares ware, CashRegister cashRegister) {
        List<Games> gameList=ware.getGames();
        List<Games> outOfStockGames=new ArrayList<>();
        for(int i=0;i<gameList.size();i++){
            Games game=gameList.get(i);
            if(game.inventory==0){
                outOfStockGames.add(game);
            }
        }

        //order 3 of any games that have an inventory of 0 and pay it.
        int costOfGame=0;
        for(Games game:outOfStockGames){
            game.addInventory(3);
            costOfGame += Math.round(game.getPrice()*3*0.5*100.0/100.0);
            ware.gameOrderedLastNight.add(game);
        }

        cashRegister.removeCash(costOfGame);
        //Putting ordered games in com.FLGS.Actions.Arrive object is not a good practice, gonna changed it one day.
    }
    public void checkCookieJar(CookieJar jar, Baker baker){
        int cookies=jar.getCookiesInJar();
        if(cookies>0){
            baker.deductDeliverPackages();
        }else{
            baker.addDeliverPackages();
        }
    }
}

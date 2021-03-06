package com.FLGS.Store.Employees;
//An example of identity - CashierTasks receives a com.FLGS.Games.Games object from
//com.FLGS.Store.StoreVisitors.Customer.buyGame(). It then passes it to com.FLGS.Actions.Sold.doAction() where it
//updates the com.FLGS.Games.Games object.

//An exmaple of strategy - a set of behaviors of cashier is turned into a sets of objects.
//So, the behaviors here is interchangeable, for example, the stack method can be change with HighestFirst or WidestFirst.


import com.FLGS.Actions.*;
import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Wares;

public class CashierTask {
    Arrive arrive;
    Close close;
    Count count;
    Open open;
    Order order;
    Stack stack;
    Vacuum vacuum;
    Sold sold;
    Cashier cashier;

    public CashierTask(Stack stack, Cashier cashier) {
        this.cashier = cashier;
        this.arrive = new Arrive(this.cashier);
        this.close = new Close(this.cashier);
        this.count = new Count(this.cashier);
        this.open = new Open(this.cashier);
        this.stack = stack;
        this.vacuum = new Vacuum(this.cashier);
        this.order = new Order(this.cashier);
        this.sold = new Sold(this.cashier);

    }
    public void arrive(int arriveDay, Wares ware){
        arrive.announce(arriveDay);
        arrive.doAction(ware);
    }
    public void count(CashRegister register){
        count.announce(register);
        count.doAction(register);
    }
    public void close(){
        close.announce();
        close.doAction();
    }
    public void open(){
        open.announce();
        open.doAction();
    }
    public void order(Wares ware,CashRegister register){
        order.announce();
        order.doAction(ware,register);
    }
    public void stack(Wares ware,String employeeName){
        stack.announce(this.cashier);
        stack.doAction(ware);
        stack.announceStackOrder(ware,employeeName,this.cashier);
    }
    public void vacuum(Wares ware,int damageRate){
        vacuum.announce();
        vacuum.doAction(damageRate,ware);
    }
    public void sold(Games gameSold, String customerName, CashRegister cashRegister){
        sold.doAction(gameSold,customerName,cashRegister);
    }
    public void checkCookies(CookieJar jar, Baker baker){
        order.checkCookieJar(jar, baker);
    }



}

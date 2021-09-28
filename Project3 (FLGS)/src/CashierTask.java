//An example of identity - CashierTasks receives a Games object from
//Customer.buyGame(). It then passes it to Sold.doAction() where it
//updates the Games object.


public class CashierTask {
    Arrive arrive;
    Close close;
    Count count;
    Open open;
    Order order;
    Stack stack;
    Vacuum vacuum;
    Sold sold = new Sold();
    CashRegister cashRegister;
    public CashierTask(Stack stack) {
        this.arrive = new Arrive();
        this.close = new Close();
        this.count = new Count();
        this.open = new Open();
        this.stack = stack;
        this.vacuum = new Vacuum();
        this.order = new Order();
    }
    public void arrive(String employeeName, int arriveDay, Wares ware){
        arrive.announce(employeeName, arriveDay);
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
        stack.announce();
        stack.doAction(ware);
        stack.announceStackOrder(ware,employeeName);
    }
    public void vacuum(Wares ware,int damageRate){
        vacuum.announce();
        vacuum.doAction(damageRate,ware);
    }
    public void sold(Games gameSold, String customerName,CashRegister cashRegister){
        sold.doAction(gameSold,customerName,cashRegister);
    }



}

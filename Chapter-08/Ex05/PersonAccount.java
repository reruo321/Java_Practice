package Ch08.Ex05;

public class PersonAccount {
    private String name;
    private long amount;
    public PersonAccount(String name, long amount){
        this.name = name;
        this.amount = amount;
    }
    public String getName(){
        return name;
    }
    public long getAmount(){
        return amount;
    }
    public void deposit(long money) throws AmountException{
        try{
            if(money < 0)
                throw new AmountException();
            amount += money;
        }
        catch(AmountException e){
            System.out.println(e.toString());
        }
    }
    public void withdraw(long money) throws AmountException, OutOfAmount {
        try{
            if(money < 0)
                throw new AmountException();
            if(amount < money)
                throw new OutOfAmount();
            amount -= money;
        }
        catch(AmountException | OutOfAmount e){
            System.out.println(e.toString());
        }
    }
    public String toString(){
        return String.format("이름: %s   잔액: %d원\n", name, amount);
    }
}

class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
        
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(inValidAccount(account1) || inValidAccount(account2)) return false;
        long bal1 = balance[account1-1];
        long bal2 = balance[account2-1];

        if(money>bal1) return false;

        balance[account1-1]-=money;
        balance[account2-1]+=money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(inValidAccount(account)) return false;
        balance[account-1]+=money;

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(inValidAccount(account)) return false;

        long bal = balance[account-1];

        if(money>bal) return false;

        balance[account-1]-=money;

        return true;
    }

    public boolean inValidAccount(int acc){
        if(acc<=0 || acc>balance.length) return true;

        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
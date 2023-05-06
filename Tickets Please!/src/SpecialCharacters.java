public class SpecialCharacters extends Liar {
    private int specialCharacterAmount=2;
    private int scamNumber; // amount a time a chaacter can be scammed important for saul since he is "old" but would never be scammed.
    public SpecialCharacters (){
        // in this case fake numbers that are not important will be set to the real values.
        int ranChar = (int)(Math.random()*specialCharacterAmount);
        switch(ranChar){
            case 0:
            firstName = "James";
            lastName="Mcguill"; 
            age=41; 
            moneyCharged =300; 
            idNum="7777";

            fakeAge=age;
            fakeFirstName = "Saul";
            fakeLastName="Goodman"; 
            fakeMoneyCharged=0;
            fakeIDNum=idNum;
            scamNumber=0;
            break;
            case 1:
            firstName = "Jorji";
            lastName="Costava"; 
            age=59; 
            moneyCharged =300;
            idNum="3468";

            fakeFirstName = "Potato";
            fakeLastName="Man"; 
            fakeAge=59;
            fakeMoneyCharged=3000;
            fakeIDNum="3467+1";
            scamNumber=5; // he is not great at scamming you in "papers please"
            break;
        }
        
    }

    @Override
    public String customerInfo(){//uses polymorphism
        return ("Name: "+this.fakeFirstName +" "+ this.fakeLastName +" Age: " + this.fakeAge + " Ticket ID: " + this.fakeIDNum + " Initial Charge: " + fakeMoneyCharged);
    }

    // special characters can lie diffently about the amount of money charged
    public int getFakeMoneyCharged(){
        return this.fakeMoneyCharged;
    }
    public int getScamNumber(){
        return this.scamNumber;
    }
}

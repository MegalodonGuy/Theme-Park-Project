public class SpecialCharacters extends Liar {
    private int specialCharacterAmount=2;
    private int scamNumber; // amount a time a character can be scammed important for saul since he is "old" but would never be scammed.
    private String specialDialog;
    private static boolean character1Appeared=false; 
    private static boolean character2Appeared=false; 
    private boolean isSpecial=true;
    public SpecialCharacters (){
        // in this case fake numbers that are not important will be set to the real values.
        int ranChar = (int)(Math.random()*specialCharacterAmount);
        switch(ranChar){ // if character has already appeard, it gets replaced with a normal liar.
            case 0:
            if (!character1Appeared){
            isSpecial=true;
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
            specialDialog ="\"You don't need a criminal lawyer, you need a CRIMINAL lawyer. With me you can get away with more ... accidents\"";
            character1Appeared=true;
            } 
            else { //else make a new liar
                isSpecial=false;
            }
            break;
            case 1:
            if(!character2Appeared){
            isSpecial=true;
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
            specialDialog ="\"Hi I know your job is very hard but can you let ol' potato man through? Ill make sure park is safe!\"";
            character2Appeared=true;
            } else{
                isSpecial=false;
            }
            break;
        }
        
    }

    @Override
    public String customerInfo(){//uses polymorphism
        if(this.isSpecial){
        return ("Name: "+this.fakeFirstName +" "+ this.fakeLastName +" Age: " + this.fakeAge + " Ticket ID: " + this.fakeIDNum + " Initial Charge: " + fakeMoneyCharged+" "+specialDialog);
        }
        return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged); // if special character appeared already replace with a truth customer
    }

    // special characters can lie diffently about the amount of money charged
    public int getFakeMoneyCharged(){
        return this.fakeMoneyCharged;
    }
    public int getScamNumber(){
        return this.scamNumber;
    }

}

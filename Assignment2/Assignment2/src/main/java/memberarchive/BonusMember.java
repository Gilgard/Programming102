package memberarchive;

import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance;
    private String name;
    private String emailAddress;
    private String password;
    private static int SILVER_LIMIT = 25000;
    private static int GOLD_LIMIT = 75000;
    private memberships.Membership membership;

    public BonusMember(int id, LocalDate entryDate, int bonusPointsBalance, String name, String email) {
        this.memberNumber = id;
        this.enrolledDate = entryDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.emailAddress = email;
        checkAndSetMembership();
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    private void checkAndSetMembership(){
        if(bonusPointsBalance < SILVER_LIMIT && bonusPointsBalance < GOLD_LIMIT) this.membership = new memberships.BasicMembership();
        if(bonusPointsBalance >= SILVER_LIMIT && bonusPointsBalance < GOLD_LIMIT) this.membership = new memberships.SilverMembership();
        if(bonusPointsBalance >= GOLD_LIMIT) this.membership = new memberships.GoldMembership();
    }

    public String toString() {
        String s = "Member number: " + memberNumber + " Name: " + name + " E-mail address: " + emailAddress + " Enrollment date: " 
                        + enrolledDate + "\nMembership status: " + getMembershipLevel() + "\nBonus points: " + bonusPointsBalance;
        return s;
    }



}
package memberships;

public class BasicMembership extends Membership {

    public int registerPoints(int bonusPointsBalance, int newPoints) {
        return bonusPointsBalance + newPoints;
    }

    public String getMembershipName() {
        return "Basic membership";
    }
    
}

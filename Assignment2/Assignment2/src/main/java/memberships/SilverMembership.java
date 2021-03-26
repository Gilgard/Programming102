package memberships;

public class SilverMembership extends Membership {
    private static float POINTS_SCALING_FACTOR = 1.2f;

    public int registerPoints(int bonusPointsBalance, int newPoints) {
        return bonusPointsBalance + Math.round(newPoints * POINTS_SCALING_FACTOR);
    }

    public String getMembershipName() {
        return "Silver membership";
    }
    
}

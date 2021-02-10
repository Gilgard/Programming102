package memberships;

public class GoldMembership extends Membership {
    private static float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private static float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    public int registerPoints(int bonusPointsBalance, int newPoints) {
        if (bonusPointsBalance >= 90000)
            return bonusPointsBalance + Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_2);
        return bonusPointsBalance + Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL_1);
    }

    public String getMembershipName() {
        return "Gold membership";
    }
    
}

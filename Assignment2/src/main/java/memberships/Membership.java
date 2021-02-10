package memberships;

public abstract class Membership {
    public abstract int registerPoints(int bonusPointsBalance, int newPoints);
    public abstract String getMembershipName();
}
package oracle.demo.oow.bd.pojo;

public enum RatingType {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    NO_RATING(0);

    private int rating;

    //自己改的
    private RatingType(int rating) {
		this.rating=rating;
	}

    public int getValue() {

        switch (this) {
        case ONE:
            rating = 1;
            break;
        case TWO:
            rating = 2;
            break;
        case THREE:
            rating = 3;
            break;
        case FOUR:
            rating = 4;
            break;
        case FIVE:
            rating = 5;
            break;
        default:
            rating = 0;
            break;
        }

        return rating;
    }

    public static RatingType getType(int rating) {
        RatingType type = null;
        for (RatingType rt : RatingType.values()) {
            if (rating == rt.rating) {
                type = rt;
                break;
            }
        } //EOF for

        return type;
    } //valueOf

    public static void main(String[] args) {

        System.out.println(RatingType.FIVE.getValue());
    }
}



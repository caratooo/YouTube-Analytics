package use_case.trending;

public class TrendingInputData {
    final private String categoryInt;

    public TrendingInputData(String categoryInt) {
        this.categoryInt= categoryInt;
    }

    String getCategoryId() { return categoryInt; }

    Boolean equal(String compare){
        return categoryInt.equals(compare);
    }
}

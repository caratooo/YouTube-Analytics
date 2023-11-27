package use_case.trending;

public class TrendingInputData {
    final private Integer category;

    public TrendingInputData(Integer category) {
        this.category= category;
    }

    Integer getCategoryId() { return category; }
}

package interface_adapter.trending;

public class TrendingCategorySelectState {
    private String category = "0";

    public TrendingCategorySelectState(TrendingCategorySelectState copy) {
        category = copy.category;
    }

    public TrendingCategorySelectState() {}

    public String getCategoryId() { return category; }

    public void setCategoryId(String category) { this.category = category; }
}

package interface_adapter.trending;

public class TrendingCategorySelectState {
    private Integer category = null;

    public TrendingCategorySelectState(TrendingCategorySelectState copy) {
        category = copy.category;
    }

    public TrendingCategorySelectState() {}

    public Integer getCategoryId() { return category; }

    public void setCategoryId(Integer category) { this.category = category; }
}

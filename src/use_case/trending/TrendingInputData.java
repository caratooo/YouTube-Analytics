package use_case.trending;

public class TrendingInputData {
    final private String categoryInt;

    public TrendingInputData(String categoryInt) {
        this.categoryInt= categoryInt;
    }

    String getCategoryId() { return categoryInt; }
    String getCategoryStr(){
        if(categoryInt.equals("0")){
            return "General";
        }
        else if(categoryInt.equals("1")){
            return "Movies";
        }
        else if(categoryInt.equals("10")){
            return "Music";
        }
        else if(categoryInt.equals("17")){
            return "Sports";
        }
        else if(categoryInt.equals("20")){
            return "Gaming";
        }
        else if(categoryInt.equals("25")){
            return "News";
        }
        else {
            return "Animals"; // selectedCategory.equals("15")
        }
    }

    Boolean equal(String compare){
        return categoryInt.equals(compare);
    }
}

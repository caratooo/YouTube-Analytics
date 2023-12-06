package interface_adapter.trending_category_select;

import com.google.api.client.util.DateTime;
import interface_adapter.ViewManagerModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import org.junit.jupiter.api.Test;
import use_case.trending.TrendingOutputData;

class TrendingPresenterTest {
    @Test
    void successTest() {

        String category = "17";

        String id1 = "DHBJSDKJAN";
        String channel1 = "dbjadcna";
        String title1 = "gusahcknj";
        String description1 = "YUHJNKHGVFCDTCFYVGUBHINGVYFTDTFYVGUBH";
        DateTime dateTime1 = new DateTime("2001-01-01T18:48:38.000Z");
        int view1 = 2131131212;
        int like1 = 2134544;
        int comment1 = 234564743;

        String id2 = "DHGVXJA$^";
        String channel2 = "bhjakdnj";
        String title2 = "gusahhjq112j";
        String description2 = "YUHJNK228131jkjTDTFYVGUBH";
        DateTime dateTime2 = new DateTime("2002-02-02T18:48:38.000Z");
        int view2 = 11021212;
        int like2 = 213313;
        int comment2 = 234123;

        String id3 = "DHGV213$^";
        String channel3 = "bas12dnj";
        String title3 = "g321daq112j";
        String description3 = "YUHwqdqi212e213VGUBH";
        DateTime dateTime3 = new DateTime("2003-03-03T18:48:38.000Z");
        int view3 = 11992;
        int like3 = 2133;
        int comment3 = 23413;


        TrendingOutputData output = new TrendingOutputData(category,id1,channel1,title1,description1,dateTime1,view1,like1,comment1,
                id2,channel2,title2,description2,dateTime2,view2,like2,comment2,id3,channel3,title3,description3,dateTime3,view3,like3,comment3);

        TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();

        TrendingCategorySelectViewModel trendingCategorySelectViewModel = new TrendingCategorySelectViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        TrendingPresenter presenter = new TrendingPresenter(trendingCategorySelectViewModel, trendingDataViewModel, viewManagerModel);
        presenter.prepareDataView(output);

    }

}

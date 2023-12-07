package views;

import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import org.junit.jupiter.api.Test;
import use_case.trending.TrendingDataAccessInterface;

import java.io.IOException;

class TrendingDataViewTest {
//    @Mock
//    private TrendingDataViewModel trendingDataViewModel;
//    @Mock
//    private HomeViewModel homeViewModel;
//    @Mock
//    private ViewManagerModel viewManagerModel;
//
    private TrendingDataView trendingDataView;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        trendingDataView = new TrendingDataView(trendingDataViewModel, homeViewModel, viewManagerModel);
//    }
//
//    @Test
//    void testPropertyChange() {
//        // Simulate a property change
//        TrendingDataState mockState = new TrendingDataState();
//        mockState.setCategory("Music");
//        mockState.setTopOneVideoId("123");
//        // ...
//
//        // Trigger property change
//        PropertyChangeEvent evt = new PropertyChangeEvent(trendingDataViewModel, "state", null, mockState);
//        trendingDataView.propertyChange(evt);
//    }

        @Test
    void initialize() throws IOException {
//        TrendingDataAccessInterface youtubeRepository = new VideoSearchDataAccessObject();
        TrendingDataAccessInterface youtubeRepository = new YouTubeDataAccess();

        TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        HomeViewModel homeViewModel = new HomeViewModel();

        TrendingDataView trendingDataView = new TrendingDataView(trendingDataViewModel, homeViewModel, viewManagerModel);

    }


}

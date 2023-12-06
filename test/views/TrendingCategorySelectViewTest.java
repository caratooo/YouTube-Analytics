package views;

import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.trending_category_select.TrendingController;
import interface_adapter.trending_category_select.TrendingPresenter;
import interface_adapter.trending_data.TrendingDataViewModel;
import org.junit.jupiter.api.Test;
import use_case.trending.TrendingDataAccessInterface;
import use_case.trending.TrendingInputData;
import use_case.trending.TrendingInteractor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrendingCategorySelectViewTest {
//    @Mock
//    private TrendingController controller;
//    @Mock
//    private TrendingCategorySelectViewModel trendingCategorySelectViewModel;
//    @Mock
//    private HomeViewModel homeViewModel;
//    @Mock
//    private ViewManagerModel viewManagerModel;
//
//    private TrendingCategorySelectView view;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        view = new TrendingCategorySelectView(controller, trendingCategorySelectViewModel, homeViewModel, viewManagerModel);
//    }

    @Test
    void initialize() {
//        TrendingDataAccessInterface youtubeRepository = new VideoSearchDataAccessObject();
        TrendingDataAccessInterface youtubeRepository = new YouTubeDataAccess();

        TrendingCategorySelectViewModel trendingCategorySelectViewModel = new TrendingCategorySelectViewModel();
        TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TrendingPresenter presenter = new TrendingPresenter(trendingCategorySelectViewModel, trendingDataViewModel, viewManagerModel);

        TrendingInteractor interactor = new TrendingInteractor(youtubeRepository, presenter);
        TrendingController controller = new TrendingController(interactor);

        HomeViewModel homeViewModel = new HomeViewModel();

        TrendingCategorySelectView trendingCategorySelectView = new TrendingCategorySelectView(controller, trendingCategorySelectViewModel, homeViewModel, viewManagerModel);

        // test handleCategorySelection
        ArrayList<String> possibleCategory = new ArrayList<String>();
        possibleCategory.add("General");
        possibleCategory.add("Movies");
        possibleCategory.add("Music");
        possibleCategory.add("Sports");
        possibleCategory.add("Gaming");


        for (int i = 0; i < possibleCategory.size(); i++) {
            TrendingInputData input = new TrendingInputData(trendingCategorySelectView.handleCategorySelection(possibleCategory.get(i)));
            assertEquals(input.getCategoryStr(), possibleCategory.get(i));
        }

    }

//    @Test
//    void testPropertyChange() {
//        // Simulate a property change
//        PropertyChangeEvent evt = new PropertyChangeEvent(view, "someProperty", null, null);
//        view.propertyChange(evt);
//    }



}

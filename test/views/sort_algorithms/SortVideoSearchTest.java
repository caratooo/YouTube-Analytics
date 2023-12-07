package views.sort_algorithms;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class SortVideoSearchTest {
    private SortVideoSearch sorter;

    @Before
    public void init() {
        sorter = new SortVideoSearch();
    }

    @Test
    public void sortPanelTest() {
        String data = "videoSearch,videoid,channelName,title,descriptiondddddddddddddddddddddddddddddddddddddddd,videoPublishDate,viewCount,likeCount,commentCount";
        Integer number = 1;
        JButton button = new JButton();
        sorter.sort(data, number, button);
    }
}

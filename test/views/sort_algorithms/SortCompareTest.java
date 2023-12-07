package views.sort_algorithms;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

public class SortCompareTest {
    private SortCompare sorter;

    @Before
    public void init() {
        sorter = new SortCompare();
    }

    @Test
    public void sortPanelTest() {
        String data = "compare,videoid1,channelName,title,descriptiondddddddddddddddddddddddddddddddddddddddd,videoPublishDate,viewCount,likeCount,commentCount,videoid2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount";
        Integer number = 1;
        JButton button = new JButton();
        sorter.sort(data, number, button);
    }
}

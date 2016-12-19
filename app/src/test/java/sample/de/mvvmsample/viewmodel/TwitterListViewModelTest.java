package sample.de.mvvmsample.viewmodel;

import android.net.Uri;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import sample.de.mvvmsample.R;
import sample.de.mvvmsample.model.Twit;
import sample.de.mvvmsample.service.TwitterService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by dkalinowski on 19.12.16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Uri.class)
public class TwitterListViewModelTest {

    private static final Twit SAMPLE_TWIT = new Twit("title", "content", "author", null);
    private static final Twit SAMPLE_TWIT2 = new Twit("title2", "content2", "author2", null);

    private static final List<Twit> SAMPLE_TWITS = Arrays.asList(SAMPLE_TWIT, SAMPLE_TWIT2);

    @Test
    public void onTwitsLoaded() throws Exception {
        TwitterListViewModel twitterListViewModel = spy(new TwitterListViewModel());
        Date sampleDate = new Date(1483225200000l);
        doReturn(sampleDate).when(twitterListViewModel).getDate();

        twitterListViewModel.onTwitsLoaded(SAMPLE_TWITS);
        twitterListViewModel.onTwitsLoaded(SAMPLE_TWITS);

        assertEquals(2, twitterListViewModel.getTwits().size());
        assertEquals(false, twitterListViewModel.getIsLoading().get());
        assertEquals("Synced: 2017/01/01 00:00:00", twitterListViewModel.getLastSynced().get());
    }

    @Test
    public void onClick() throws Exception {
        TwitterListViewModel twitterListViewModel = new TwitterListViewModel();

        View sampleView = mock(View.class);
        doReturn(R.id.btnLoad).when(sampleView).getId();

        TwitterService twitterService = mock(TwitterService.class);
        twitterListViewModel.setTwitterService(twitterService);

        twitterListViewModel.onClick(sampleView);

        assertEquals(true, twitterListViewModel.getIsLoading().get());
        verify(twitterService).requestTwits(any(TwitterService.TwitsLoader.class));
    }



}
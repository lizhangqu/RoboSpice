package cn.edu.zafu.robospicedemo.service;

/**
 * Created by lizhangqu on 2015/4/15.
 */
import com.octo.android.robospice.Jackson2GoogleHttpClientSpiceService;

public class HttpClientSpiceService extends Jackson2GoogleHttpClientSpiceService {

    @Override
    public int getThreadCount() {
        return 4;
    }

}

package cn.edu.zafu.robospicedemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import cn.edu.zafu.robospicedemo.service.HttpClientSpiceService;
import cn.edu.zafu.robospicedemo.webservice.PersonRequest;
import cn.edu.zafu.robospicedemo.webservice.json.PersonJson;


public class MainActivity extends ActionBarActivity {
    private SpiceManager spiceManager = new SpiceManager(HttpClientSpiceService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestTestData();
    }

    public void requestTestData() {
        PersonRequest request = new PersonRequest();
        request.setUrl("http://121.199.33.93/7plus/index/hello");
        spiceManager.execute(request, new RequestListener<PersonJson>() {
            @Override
            public void onRequestFailure(SpiceException spiceException) {

            }

            @Override
            public void onRequestSuccess(PersonJson personJson) {
                Toast.makeText(getApplicationContext(),personJson.getId()+" "+personJson.getName()+" "+personJson.getAge()+" "+personJson.getAddress(),Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        if (spiceManager.isStarted()) {
            spiceManager.shouldStop();
        }
        super.onStop();
    }
}

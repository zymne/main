package org.wordpress.android.ui.posts;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.wordpress.android.WordPress;

public class PostLocationActivity extends FragmentActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            ViewPostFragment postFragment = new ViewPostFragment();
            
            populateLoactionList();
            
            getSupportFragmentManager().beginTransaction().add(
                    android.R.id.content, postFragment).commitAllowingStateLoss();
        }
    }
    
    
    
    public void populateLoactionList()
    {
        
        Map<String, String> p = new HashMap<String, String>();
        
        p.put("ll", "40.7,-74");
        
        WordPress.restClient.get("https://api.foursquare.com/v2/venues/search", p, null, null, null);
        
    }

}

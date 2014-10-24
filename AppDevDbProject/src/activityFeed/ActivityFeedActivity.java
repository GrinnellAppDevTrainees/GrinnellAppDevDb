package activityFeed;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.appdevdbproject.R;

/**
 * Implements ActivityFeedActivity
 * @author Albert Owusu-Asare
 *@version version 0.1 of October 2014
 */
public class ActivityFeedActivity extends FragmentActivity implements
		ActionBar.TabListener {

	// Variable types created from tab classes to initialize an actionBar, a tab
	// menu in the actionBar,
	// and a base for swipe-able views
	private ActionBar actionBar;
	private TabsAdapter mAdapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_feed);

		// Initialization for an actionBar, a tab menu, and a base for
		// swipe-able views
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsAdapter(getSupportFragmentManager());
		// Setting adapter for ViewPager, setting navigation mode of actionBar
		// to 'Tabs'
		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// set Text of the Tabs with respective names
		for (String tab_name : Utilities.tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			/**
			 * on swiping the <code>viewPager</code> creates respective tab
			 * selected
			 **/

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}//onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_feed, menu);
		return true;
	}//onCreateOptionsMenu

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}//onOptionsItemSelected

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// For the tab that we are currently on, the actionBar will show the
		// appropriate
		// tab selected.
		viewPager.setCurrentItem(tab.getPosition());
	}//onTabSelected

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}//onTabUnselected

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}//onTabReselected
}//ActivityFeedActivity

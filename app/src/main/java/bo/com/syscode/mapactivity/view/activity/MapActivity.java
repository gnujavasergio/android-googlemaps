package bo.com.syscode.mapactivity.view.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import bo.com.syscode.mapactivity.R;
import bo.com.syscode.mapactivity.view.fragment.MapFragment;
import bo.com.syscode.mapactivity.view.fragment.WelcomeFragment;

public class MapActivity extends AppCompatActivity {

	private Fragment currentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		currentFragment = new WelcomeFragment();
		setUpFragment(currentFragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_map, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_welcome:
				currentFragment = new WelcomeFragment();
				break;
			case R.id.action_map:
				currentFragment = new MapFragment();
				break;
		}
		setUpFragment(currentFragment);
		return super.onOptionsItemSelected(item);
	}

	public void setUpFragment(Fragment fragment) {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
	}
}

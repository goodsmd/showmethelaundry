package sincere.kimjungchul.smartwheel.SignUp;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import sincere.kimjungchul.smartwheel.R;


/**
* Created by user on 2015-08-01.
*/
public class SignUpActivity extends FragmentActivity{
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_signup);

       FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       ft.replace(R.id.frame_container_signup, new SignUpUserInformationFragment());
       ft.commit();

   }
}

package test.cbuitest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MyCustomView customView;
    ImageView imageView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        textView = (TextView) findViewById(R.id.textView);
        customView = (MyCustomView) findViewById(R.id.myCsutomView);
        imageView = (ImageView) findViewById(R.id.imageView);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTransition();
            }
        });
    }

    private void startReveal() {

        Animator animator = ViewAnimationUtils.createCircularReveal(imageView, imageView.getMeasuredWidth() / 2, imageView.getMeasuredHeight() / 2, 0, 600);
        animator.setDuration(1000);
        imageView.setVisibility(View.VISIBLE);
        animator.start();

    }

    private void startTransition() {
        Intent intent = new Intent(this, SecondActivity.class);
//        ActivityOptions options =
//                ActivityOptions.makeSceneTransitionAnimation(this,
//                        imageView,
//                        "image1");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create((View) imageView, "image1"),
                Pair.create((View) fab, "fab1"));
        startActivity(intent, options.toBundle());
    }

    private void animate() {

//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 500f);
//        animator.setDuration(1000);
//        animator.start();
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//
//            }
//        });

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 0f, 500f);
//        objectAnimator.setDuration(1000);
//        objectAnimator.start();

//        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
//        Keyframe kf1 = Keyframe.ofFloat(0.5f, 200f);
//        Keyframe kf2 = Keyframe.ofFloat(1f, 400f);
//
//        PropertyValuesHolder pvh = PropertyValuesHolder.ofKeyframe("radius", kf0,kf1, kf2);

        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0.5f);
        animator.setDuration(1000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
                animator2.setDuration(1000);
                animator2.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

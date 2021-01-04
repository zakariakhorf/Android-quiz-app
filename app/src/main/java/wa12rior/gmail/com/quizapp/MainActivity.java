package wa12rior.gmail.com.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.submit_button);

//        I'm setting OnClickListener to my submit button

		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				displayToast(getScore());
			}
		});
	}

	/**
	 * This function count and return user score
	 *
	 * @return score - points which user collect
	 */

	private int getScore() {
		int score = 0;

		// getting and checking user answers

		boolean firstCorrectAnswer = ((RadioButton) findViewById(R.id.radio_first_A)).isChecked();
		boolean fourthCorrectAnswer = ((RadioButton) findViewById(R.id.radio_fourth_A)).isChecked();

		String secondCorrectAnswer = ((EditText) findViewById(R.id.editText_second)).getText().toString();
		String sixthCorrectAnswer = ((EditText) findViewById(R.id.editText_sixth)).getText().toString();

		boolean firstPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_B)).isChecked();
		boolean secondPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_C)).isChecked();
		boolean thirdPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_A)).isChecked();
		boolean fourthPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_D)).isChecked();

		boolean firstPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_A)).isChecked();
		boolean secondPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_B)).isChecked();
		boolean thirdPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_C)).isChecked();
		boolean fourthPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_D)).isChecked();

		if (secondCorrectAnswer.equals("Yes")) {
			score++;
		}
		if (sixthCorrectAnswer.equals("Yes")) {
			score++;
		}

		if (firstPartialFifthAnswer && secondPartialFifthAnswer && !thirdPartialFifthAnswer && !fourthPartialFifthAnswer) {
			score++;
		}
		if (firstPartialThirdAnswer && secondPartialThirdAnswer && !thirdPartialThirdAnswer && !fourthPartialThirdAnswer) {
			score++;
		}

		if (firstCorrectAnswer) {
			score++;
		}

		if (fourthCorrectAnswer) {
			score++;
		} else {
			Log.e("error", "Incorrect answer");
		}

		return score;
	}

	/**
	 * This function displays toast message with score
	 *
	 * @param points - user score
	 */

	private void displayToast(int points) {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		final String text = "Your score: " + points + "/6";

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}

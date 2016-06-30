package com.thoughtworks.marchant_guide.ui.fragment;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.convertor.UniversalConstants;
import com.thoughtworks.marchant_guide.convertor.UniversalCurrencyConvertor;
import com.thoughtworks.marchant_guide.data.TestDataSourceResourceArray;
import com.thoughtworks.marchant_guide.model.GlobalDataProvider;
import com.thoughtworks.marchant_guide.util.Utils;

/**
 * A placeholder fragment containing a Virtual keyboard to take user input and
 * convert them in corresponding credit values
 */
public class HomeFragment extends Fragment implements DialogCloseListener {

	// EditText to take inputs
	private EditText currencyInput;

	// TextView to print Credit values
	private TextView creditoutput;

	// List of keyss and Key Binding to inflate virtual keyboard
	private ArrayList<Button> listOfVirtualkeys;

	// String builder to do operation on input
	private StringBuilder inputStringBuilder, outputStringBuilder;
	private View rootView;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.frag_home, container, false);

		inputStringBuilder = new StringBuilder();
		outputStringBuilder = new StringBuilder();

		// Load data Map
		GlobalDataProvider.getGlobalDataProvider().init(getActivity());

		setUpUI();

		return rootView;
	}

	/*
	 * Fetch and style UI elements
	 */
	private void setUpUI() {

		Spinner spinnerMetal = (Spinner) rootView
				.findViewById(R.id.spinnerview);

		ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),

		R.array.array_metal_type, R.layout.item_spinner);

		adapter.setDropDownViewResource(R.layout.item_spinner);

		spinnerMetal.setAdapter(adapter);

		spinnerMetal.setPrompt("Select Metal");

		spinnerMetal.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> metalPosition, View arg1,
					int metalType, long arg3) {

				Utils.vibrate(getActivity());

				UniversalConstants.currentMetalType = metalType;

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		// Loading Font Face for styling

		currencyInput = (EditText) rootView.findViewById(R.id.currency_input);
		creditoutput = (TextView) rootView.findViewById(R.id.credits_output);

		creditoutput.setSelected(true);

		// Open Dialog to change currency system
		rootView.findViewById(R.id.current_galaxy).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						DialogFragment newFragment = new SelectGalaxySystemDialogFragment(
								HomeFragment.this);
						newFragment.show(getFragmentManager(), "dialog");

					}
				});

		// List of keys in virtual keyboard
		listOfVirtualkeys = new ArrayList<Button>();
		listOfVirtualkeys.add((Button) rootView.findViewById(R.id.one_btn));
		listOfVirtualkeys.add((Button) rootView.findViewById(R.id.five_btn));
		listOfVirtualkeys.add((Button) rootView.findViewById(R.id.ten_btn));
		listOfVirtualkeys.add((Button) rootView.findViewById(R.id.fifty_btn));
		listOfVirtualkeys.add((Button) rootView.findViewById(R.id.hundred_btn));
		listOfVirtualkeys.add((Button) rootView
				.findViewById(R.id.five_hundred_btn));
		listOfVirtualkeys
				.add((Button) rootView.findViewById(R.id.thousand_btn));

		// Add click listners on virtual keyboard

		rootView.findViewById(R.id.one_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						add(UniversalConstants.ROMAN_I);

						Utils.vibrate(getActivity());
					}
				});
		rootView.findViewById(R.id.five_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_V);

						Utils.vibrate(getActivity());
					}
				});
		rootView.findViewById(R.id.ten_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_X);

						Utils.vibrate(getActivity());

					}
				});
		rootView.findViewById(R.id.fifty_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_L);

						Utils.vibrate(getActivity());
					}
				});
		rootView.findViewById(R.id.hundred_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_C);

						Utils.vibrate(getActivity());

					}
				});
		rootView.findViewById(R.id.five_hundred_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_D);

						Utils.vibrate(getActivity());
					}
				});

		rootView.findViewById(R.id.thousand_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						add(UniversalConstants.ROMAN_M);

						Utils.vibrate(getActivity());
					}
				});

		// Clear Input
		rootView.findViewById(R.id.back_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						if (inputStringBuilder.length() > 0) {
							inputStringBuilder.deleteCharAt((inputStringBuilder
									.length()) - 1);

						}

						if (outputStringBuilder.length() > 0) {

							// remove white space
							outputStringBuilder.delete(
									outputStringBuilder.lastIndexOf(" "),
									outputStringBuilder.length());

							if (outputStringBuilder.lastIndexOf(" ") == -1) {

								// Delete first word
								outputStringBuilder.delete(0,
										outputStringBuilder.length());

							} else {
								// Delete next word
								outputStringBuilder.delete(
										outputStringBuilder.lastIndexOf(" ") + 1,
										outputStringBuilder.length());
							}

						}

						backButtonPressed(inputStringBuilder.toString(),
								outputStringBuilder.toString());
					}
				});

		// Clear everything
		rootView.findViewById(R.id.back_btn).setOnLongClickListener(
				new View.OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {

						inputStringBuilder = new StringBuilder();
						backLongPressed();
						return false;
					}
				});

		// TODO Useless
		rootView.findViewById(R.id.done_btn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						doneButtonPressed(inputStringBuilder.toString());
					}
				});
	}

	@Deprecated
	public void doneButtonPressed(String total) {
		currencyInput.setText(total);
	}

	/*
	 * Called when user press back key for too long . This method clears input
	 * field for fresh entry
	 */
	private void backLongPressed() {

		currencyInput.setText("");
		creditoutput.setText("00");

		Utils.vibrate(getActivity());
	}

	/*
	 * This function remove one symbol from the end .This button is equivalence
	 * to backspace of any keyboard.
	 */
	private void backButtonPressed(String total, String outputString) {

		// set updated value
		currencyInput.setText(outputString);

		// check if updated value is valid
		String errorMessage = UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic(total);

		if (errorMessage == null) {

			// Error is null ie. input is valid show credit value on screen

			creditoutput.setText(""
					+ UniversalCurrencyConvertor.getCurrencyInstance()
							.calculateCredit(total));

			creditoutput.setTextColor(Color.GREEN);
		} else {

			// Error is not null show corresponding error message
			creditoutput.setTextColor(Color.RED);

			creditoutput.setText(errorMessage);
		}

		Utils.vibrate(getActivity());
	}

	/*
	 * Add new symbols into existing input and evaluates credit value.
	 */
	private void add(char nextInputSymbol) {

		// Add new symbol to current input
		inputStringBuilder.append(nextInputSymbol);

		outputStringBuilder.append(GlobalDataProvider.getGlobalDataProvider()
				.getGalaxyConversionUnits().get(nextInputSymbol)
				+ " ");

		currencyInput.setText(outputStringBuilder.toString());

		// check if input is still valid
		String errorMessage = UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic(inputStringBuilder.toString());

		if (errorMessage == null) {

			// Error is null then show credit value
			creditoutput.setTextColor(Color.GREEN);

			creditoutput.setText(""
					+ UniversalCurrencyConvertor.getCurrencyInstance()
							.calculateCredit(inputStringBuilder.toString()));

		} else {

			// Error is not null then show error message
			creditoutput.setTextColor(Color.RED);

			creditoutput.setText(errorMessage);
		}

	}

	/*
	 * Called when dialog is closed and user have changed galaxy system. In this
	 * callaback we need to update keyboard layout as per new key
	 * mapping(non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.marchant_guide.ui.fragment.MyDialogListener#OnCloseDialog
	 * ()
	 */

	@Override
	public void OnCloseDialog(int currentPageIndex) {

		// Clear data
		backLongPressed();

		inputStringBuilder = new StringBuilder();
		outputStringBuilder = new StringBuilder();

		if (null != listOfVirtualkeys) {

			if (currentPageIndex == TestDataSourceResourceArray.MILKEY_WAY_GALAXY) {

				// get new conversion key map
				GlobalDataProvider.getGlobalDataProvider()
						.updateGalaxyConversionUnits(
								TestDataSourceResourceArray.MILKEY_WAY_GALAXY,
								getActivity());

				// Update current galaxy system name
				((TextView) rootView.findViewById(R.id.current_galaxy))
						.setText(getString(R.string.milkyway));

			} else if (currentPageIndex == TestDataSourceResourceArray.ANDROMEDA_GALAXY) {

				// get new conversion key map
				GlobalDataProvider.getGlobalDataProvider()
						.updateGalaxyConversionUnits(
								TestDataSourceResourceArray.ANDROMEDA_GALAXY,
								getActivity());

				// Update current galaxy system name
				((TextView) rootView.findViewById(R.id.current_galaxy))
						.setText(getString(R.string.andromeda));
			}

			// Change keyboard layout according to new key mapping
			for (int i = 0; i < listOfVirtualkeys.size(); i++) {

				listOfVirtualkeys.get(i).setText(
						GlobalDataProvider.getGlobalDataProvider()
								.getKeyMapping(i));

			}

		}

	}
}
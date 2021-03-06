package com.mysticwater.myfilms.fragments.settings;

import android.app.AlertDialog;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mysticwater.myfilms.BuildConfig;
import com.mysticwater.myfilms.R;
import com.mysticwater.myfilms.SettingsActivity;

import java.util.Calendar;

public class AboutSettingsFragment extends PreferenceFragment {

    private static final String LOG_TAG = "AboutSettingsFragment";

    private String mAppName;
    private String mAppVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings_about);

        Preference appDetailsPref = findPreference(getString(R.string.pref_app_version));
        mAppName = getString(R.string.app_name);
        mAppVersion = BuildConfig.VERSION_NAME;
        appDetailsPref.setSummary(getString(R.string.content_about_app_version, mAppName, mAppVersion));

        Preference legalPref = findPreference(getString(R.string.pref_legal));
        legalPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showLegalDialog();
                return true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        SettingsActivity.sToolbar.setTitle(getString(R.string.title_about));
    }

    private void showLegalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View layoutView = inflater.inflate(R.layout.dialog_scroll_text, null);
        TextView dialogText = (TextView) layoutView.findViewById(R.id.dialog_text);

        String legalText = buildLegalText();
        dialogText.setText(legalText);

        builder.setView(layoutView);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String buildLegalText() {
        return mAppName + " " + mAppVersion + "\n\n" +
                generateCopyrightString() + "\n\n" +
                generateLibraryReferences();
    }

    private String generateCopyrightString() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        return "Copyright \u00a9 " + year + " Mystic Water. All rights reserved.";
    }

    private String generateLibraryReferences() {
        return getString(R.string.app_name) + " is built using open source software: " + "\n" +
                butterKnifeLicence() + "\n\n" +
                expandableTextViewLicence() + "\n\n" +
                gsonLicence() + "\n\n" +
                materialFavoriteButtonLicence() + "\n\n" +
                picassoLicence() + "\n\n" +
                retrofitLicence() + "\n\n" +
                schematicLicence() + "\n\n";
    }

    private String gsonLicence() {
        return "\n" +
                "google-gson [https://github.com/google/gson]" +
                "\n\n" +
                "Copyright 2008 Google Inc.\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "    http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String retrofitLicence() {
        return "\n" +
                "Retrofit [https://github.com/square/retrofit]" +
                "\n\n" +
                "Copyright 2013 Square, Inc.\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String picassoLicence() {
        return "\n" +
                "Picasso [https://github.com/square/picasso]" +
                "\n\n" +
                "Copyright 2013 Square, Inc.\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String schematicLicence() {
        return "\n" +
                "Schematic [https://github.com/SimonVT/schematic]" +
                "\n\n" +
                "Copyright 2014 Simon Vig Therkildsen\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String butterKnifeLicence() {
        return "\n" +
                "Butter Knife [https://github.com/JakeWharton/butterknife]" +
                "\n\n" +
                "Copyright 2013 Jake Wharton\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String expandableTextViewLicence() {
        return "\n" +
                "ExpandableTextView [https://github.com/Manabu-GT/ExpandableTextView]" +
                "\n\n" +
                "Copyright 2014 Manabu Shimobe\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

    private String materialFavoriteButtonLicence() {
        return "\n" +
                "Material Favorite Button [https://github.com/IvBaranov/MaterialFavoriteButton]" +
                "\n\n" +
                "Copyright 2015 Ivan Baranov\n" +
                "\n" +
                "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                "you may not use this file except in compliance with the License.\n" +
                "You may obtain a copy of the License at\n" +
                "\n" +
                "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                "\n" +
                "Unless required by applicable law or agreed to in writing, software\n" +
                "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                "See the License for the specific language governing permissions and\n" +
                "limitations under the License.";
    }

}

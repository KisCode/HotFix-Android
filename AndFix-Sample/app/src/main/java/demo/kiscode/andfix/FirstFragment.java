package demo.kiscode.andfix;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView tvText = view.findViewById(R.id.textview_first);
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String currentTime = "currentTime:\t" + Calendar.getInstance().getTimeInMillis();
                tvText.setText(currentTime);
//                tvText.setTextColor(getContext().getColor(R.color.colorPrimary));
                Toast.makeText(getActivity(), currentTime, Toast.LENGTH_SHORT).show();
                Log.i("fixApatch", "fix add currentTime:\t" + currentTime);
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
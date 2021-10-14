package edu.cudenver.salimlakhani.phonebookapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import edu.cudenver.salimlakhani.phonebookapplication.databinding.DialogAddContactBinding;

public class AddContactDialog extends DialogFragment {

    private DialogAddContactBinding binding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = DialogAddContactBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(binding.getRoot());

        binding.buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss ();
            }
        });



        return builder.create();
    }
}

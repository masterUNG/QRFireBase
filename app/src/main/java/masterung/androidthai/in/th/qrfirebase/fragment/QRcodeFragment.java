package masterung.androidthai.in.th.qrfirebase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.Result;

import masterung.androidthai.in.th.qrfirebase.R;
import masterung.androidthai.in.th.qrfirebase.ServiceActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by masterung on 9/3/2018 AD.
 */

public class QRcodeFragment extends Fragment implements ZXingScannerView.ResultHandler{

    //    Explicit
    private ZXingScannerView zXingScannerView;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        QR Controller
        QRController();

    }   // Main Method

    private void QRController() {
        Button button = getView().findViewById(R.id.btnQRscan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zXingScannerView = new ZXingScannerView(getActivity());
                getActivity().setContentView(zXingScannerView);
                zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                    @Override
                    public void handleResult(Result result) {

                        String resultString = result.getText().toString();

                        if (resultString.length() != 0) {

                            Log.d("9MarchV1", "Result ==> " + resultString);

                        }

                    }
                });
                zXingScannerView.startCamera();

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qrcode, container, false);
        return view;
    }

    @Override
    public void handleResult(Result result) {

        try {

            Log.d("9MarchV1", "Result ==> " + result.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}   // Main Class

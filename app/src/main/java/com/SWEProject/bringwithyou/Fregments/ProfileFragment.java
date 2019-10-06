package com.SWEProject.bringwithyou.Fregments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.SWEProject.bringwithyou.Activites.Register;
import com.SWEProject.bringwithyou.model.Resturant;
import com.SWEProject.bringwithyou.model.User;
import com.SWEProject.bringwithyou.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private TextView ProfEmail,ProfName ,ProfPhone ;
    private EditText EditName, editPhone, EditPass, confirmPass;
    //private ProgressBar loadingProgress ;
    private Button ProfBtn , savechanges , cancel ;






    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_profile,container, false);


        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();


        ProfEmail = (TextView) v.findViewById(R.id.ProfEmail);
        ProfName = (TextView) v.findViewById(R.id.Profname);
        ProfPhone= (TextView) v.findViewById(R.id.ProfPhone);
        editPhone =(EditText) v.findViewById(R.id.editPhone);
        EditPass = (EditText) v.findViewById(R.id.EditPass);
        ProfBtn = (Button) v.findViewById(R.id.EditBtn);
        EditName =(EditText) v.findViewById(R.id.EditName);
        confirmPass = (EditText) v.findViewById(R.id.confirmPass);

        savechanges =(Button) v.findViewById(R.id.Savechanges) ;
        cancel =(Button) v.findViewById(R.id.cancel) ;





        EditName.setVisibility(View.INVISIBLE);
        EditPass.setVisibility(View.INVISIBLE);
        editPhone.setVisibility(View.INVISIBLE);
        confirmPass.setVisibility(View.INVISIBLE);
        savechanges.setVisibility(View.INVISIBLE);
        savechanges.setVisibility(View.INVISIBLE);




        reference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getUser();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        ProfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditName.setVisibility(View.VISIBLE);
                EditPass.setVisibility(View.VISIBLE);
                editPhone.setVisibility(View.VISIBLE);
                confirmPass.setVisibility(View.VISIBLE);


                ProfBtn.setVisibility(View.INVISIBLE);

                ProfEmail.setVisibility(View.INVISIBLE);
                ProfName.setVisibility(View.INVISIBLE);
                ProfPhone.setVisibility(View.INVISIBLE);
                savechanges.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
                EditUser();

            }
        });




        return v;

    }


    public void getUser() {
        FirebaseDatabase
                .getInstance()
                .getReference("users")
                .addChildEventListener(new ChildEventListener() {// listen to child
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevKey) {
                        User user = dataSnapshot.getValue(User.class);
                        user.setKey(dataSnapshot.getKey());
                        ProfName.setText(dataSnapshot.child("name").getValue().toString());
                        ProfEmail.setText(dataSnapshot.child("email").getValue().toString());
                        ProfPhone.setText(dataSnapshot.child("phone").getValue().toString());

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override

                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    } //end read

    public void EditUser() {
        FirebaseDatabase
                .getInstance()
                .getReference("users")
                .addChildEventListener(new ChildEventListener() {// listen to child
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevKey) {
                        final User user = dataSnapshot.getValue(User.class);
                        user.setKey(dataSnapshot.getKey());
                        EditName.setText(dataSnapshot.child("name").getValue().toString());
                        editPhone.setText(dataSnapshot.child("phone").getValue().toString());
                        EditPass.setText(dataSnapshot.child("password").getValue().toString());
                        confirmPass.setText(dataSnapshot.child("password").getValue().toString());

                        savechanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                               String name =  EditName.getText().toString();
                                String phone =  editPhone.getText().toString();
                                String pass =  EditPass.getText().toString();
                                String passConf =  confirmPass.getText().toString();


                                if(!pass.equals(passConf)){
                                    //Toast.
                                }

                                else{
                                user.setName(name);
                                user.setPhone(phone);
                                user.setPassword(pass);
                                user.setPassword(passConf);


                                //reference = reference.child(userid);
                                    reference.setValue(user);
                                }








                            }
                        });


                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override

                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    } //end read


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


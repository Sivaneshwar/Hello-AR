package com.example.helloar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity {
    private ArFragment arFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", -1);
        String sfbFile = getSFBFile(type);

        if(sfbFile != null) {
            arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
            arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
                Anchor anchor = hitResult.createAnchor();

                ModelRenderable.builder()
                        .setSource(this, Uri.parse(sfbFile))
                        .build()
                        .thenAccept(modelRenderable -> addModelToScene(anchor, modelRenderable))
                        .exceptionally(throwable -> {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(throwable.getMessage())
                                    .show();
                            return null;
                        });
            });

            Button buyButton = (Button) findViewById(R.id.buyButton);
            buyButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent sendToCart = new Intent(MainActivity.this, Purchase.class);
                    sendToCart.putExtra("type", type);
                    startActivity(sendToCart);
                }
            });

        }
        else{
            Intent returnToChoice = new Intent(MainActivity.this, ChoiceActivity.class);
            startActivity(returnToChoice);
        }
    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }

    private String getSFBFile(int type){
        String[] sfbFiles = {"Couch.sfb", "Orchids.sfb", "Armoire.sfb", "ArcticFox_Posed.sfb"};

        if(type != -1)
            return sfbFiles[type - 1];
        return null;
    }

}

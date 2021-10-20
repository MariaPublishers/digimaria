package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorNumeracyActivity6 extends BaseActivity implements View.OnClickListener {

    int i = 0, j = 0, k = 0;
    CardView next, back;
    TextView one_1, one_2, one_3, one_4, one_5, two_1, two_2, two_3, two_4, two_5,  three_1, three_2, three_3, three_4, three_5,
            four_1, four_2, four_3, four_4, four_5,  five_1, five_2, five_3, five_4, five_5;
    TextView l1_drop1, l1_drop2, l1_drop3, l1_drop4, l1_drop5, l2_drop1, l2_drop2, l2_drop3, l2_drop4, l2_drop5,
            l3_drop1, l3_drop2, l3_drop3, l3_drop4, l3_drop5, l4_drop1, l4_drop2, l4_drop3, l4_drop4, l4_drop5,
            l5_drop1, l5_drop2, l5_drop3, l5_drop4, l5_drop5;
    TextView h1_drop1, h1_drop2, h1_drop3, h1_drop4, h1_drop5, h2_drop1, h2_drop2, h2_drop3, h2_drop4, h2_drop5,
            h3_drop1, h3_drop2, h3_drop3, h3_drop4, h3_drop5, h4_drop1, h4_drop2, h4_drop3, h4_drop4, h4_drop5,
            h5_drop1, h5_drop2, h5_drop3, h5_drop4, h5_drop5;
    int oneh1 = 0, oneh2 = 0, oneh3 = 0, oneh4 = 0, oneh5 = 0, onel1 = 0, onel2 = 0, onel3 = 0, onel4 = 0, onel5 = 0,
            twoh1 = 0, twoh2 = 0, twoh3 = 0, twoh4 = 0, twoh5 = 0, twol1 = 0, twol2 = 0, twol3 = 0, twol4 = 0, twol5 = 0,
            threeh1 = 0, threeh2 = 0, threeh3 = 0, threeh4 = 0, threeh5 = 0, threel1 = 0, threel2 = 0, threel3 = 0, threel4 = 0, threel5 = 0,
            fourh1 = 0, fourh2 = 0, fourh3 = 0, fourh4 = 0, fourh5 = 0, fourl1 = 0, fourl2 = 0, fourl3 = 0, fourl4 = 0, fourl5 = 0,
            fiveh1 = 0, fiveh2 = 0, fiveh3 = 0, fiveh4 = 0, fiveh5 = 0, fivel1 = 0, fivel2 = 0, fivel3 = 0, fivel4 = 0, fivel5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy6);

        currentContext = SeniorNumeracyActivity6.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        one_1.setOnLongClickListener(longClickListener);
        one_2.setOnLongClickListener(longClickListener);
        one_3.setOnLongClickListener(longClickListener);
        one_4.setOnLongClickListener(longClickListener);
        one_5.setOnLongClickListener(longClickListener);
        two_1.setOnLongClickListener(longClickListener);
        two_2.setOnLongClickListener(longClickListener);
        two_3.setOnLongClickListener(longClickListener);
        two_4.setOnLongClickListener(longClickListener);
        two_5.setOnLongClickListener(longClickListener);
        three_1.setOnLongClickListener(longClickListener);
        three_2.setOnLongClickListener(longClickListener);
        three_3.setOnLongClickListener(longClickListener);
        three_4.setOnLongClickListener(longClickListener);
        three_5.setOnLongClickListener(longClickListener);
        four_1.setOnLongClickListener(longClickListener);
        four_2.setOnLongClickListener(longClickListener);
        four_3.setOnLongClickListener(longClickListener);
        four_4.setOnLongClickListener(longClickListener);
        four_5.setOnLongClickListener(longClickListener);
        five_1.setOnLongClickListener(longClickListener);
        five_2.setOnLongClickListener(longClickListener);
        five_3.setOnLongClickListener(longClickListener);
        five_4.setOnLongClickListener(longClickListener);
        five_5.setOnLongClickListener(longClickListener);

        l1_drop1.setOnDragListener(dragListenre);
        l1_drop2.setOnDragListener(dragListenre);
        l1_drop3.setOnDragListener(dragListenre);
        l1_drop4.setOnDragListener(dragListenre);
        l1_drop5.setOnDragListener(dragListenre);
        l2_drop1.setOnDragListener(dragListenre);
        l2_drop2.setOnDragListener(dragListenre);
        l2_drop3.setOnDragListener(dragListenre);
        l2_drop4.setOnDragListener(dragListenre);
        l2_drop5.setOnDragListener(dragListenre);
        l3_drop1.setOnDragListener(dragListenre);
        l3_drop2.setOnDragListener(dragListenre);
        l3_drop3.setOnDragListener(dragListenre);
        l3_drop4.setOnDragListener(dragListenre);
        l3_drop5.setOnDragListener(dragListenre);
        l4_drop1.setOnDragListener(dragListenre);
        l4_drop2.setOnDragListener(dragListenre);
        l4_drop3.setOnDragListener(dragListenre);
        l4_drop4.setOnDragListener(dragListenre);
        l4_drop5.setOnDragListener(dragListenre);
        l5_drop1.setOnDragListener(dragListenre);
        l5_drop2.setOnDragListener(dragListenre);
        l5_drop3.setOnDragListener(dragListenre);
        l5_drop4.setOnDragListener(dragListenre);
        l5_drop5.setOnDragListener(dragListenre);

        h1_drop1.setOnDragListener(dragListenre);
        h1_drop2.setOnDragListener(dragListenre);
        h1_drop3.setOnDragListener(dragListenre);
        h1_drop4.setOnDragListener(dragListenre);
        h1_drop5.setOnDragListener(dragListenre);
        h2_drop1.setOnDragListener(dragListenre);
        h2_drop2.setOnDragListener(dragListenre);
        h2_drop3.setOnDragListener(dragListenre);
        h2_drop4.setOnDragListener(dragListenre);
        h2_drop5.setOnDragListener(dragListenre);
        h3_drop1.setOnDragListener(dragListenre);
        h3_drop2.setOnDragListener(dragListenre);
        h3_drop3.setOnDragListener(dragListenre);
        h3_drop4.setOnDragListener(dragListenre);
        h3_drop5.setOnDragListener(dragListenre);
        h4_drop1.setOnDragListener(dragListenre);
        h4_drop2.setOnDragListener(dragListenre);
        h4_drop3.setOnDragListener(dragListenre);
        h4_drop4.setOnDragListener(dragListenre);
        h4_drop5.setOnDragListener(dragListenre);
        h5_drop1.setOnDragListener(dragListenre);
        h5_drop2.setOnDragListener(dragListenre);
        h5_drop3.setOnDragListener(dragListenre);
        h5_drop4.setOnDragListener(dragListenre);
        h5_drop5.setOnDragListener(dragListenre);


        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
        v.startDrag(data, shadow, v, 0);
        return false;
    };

    View.OnDragListener dragListenre = (v, event) -> {
        int dragEvent = event.getAction();
        final View view = (View) event.getLocalState();

        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_STARTED:
            // Executed after startDrag() is called.
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                // Executed after the Drag Shadow enters the drop area
                break;
            case DragEvent.ACTION_DROP:
                if (view.getId() == R.id.one_1 && v.getId() == R.id.l1_drop1) {
                    if (onel1 == 0) {
                        l1_drop1.setText(R.string._4);
                        onel1 += 1;
                        if (onel1 == 1 && oneh1 == 1) {
                            one_1.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_2 && v.getId() == R.id.l1_drop2) {
                    if (onel2 == 0) {
                        if (onel1 == 1) {
                            l1_drop2.setText(R.string._11);
                            onel2 += 1;
                            if (onel2 == 1 && oneh2 == 1) {
                                one_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_3 && v.getId() == R.id.l1_drop3) {
                    if (onel3 == 0) {
                        if (onel2 == 1) {
                            l1_drop3.setText(R.string._21);
                            onel3 += 1;
                            if (onel3 == 1 && oneh3 == 1) {
                                one_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_4 && v.getId() == R.id.l1_drop4) {
                    if (onel4 == 0) {
                        if (onel3 == 1) {
                            l1_drop4.setText(R.string._54);
                            onel4 += 1;
                            if (onel4 == 1 && oneh4 == 1) {
                                one_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_5 && v.getId() == R.id.l1_drop5) {
                    if (onel5 == 0) {
                        if (onel4 == 1) {
                            l1_drop5.setText(R.string._98);
                            onel5 += 1;
                            i += 1;
                            if (onel5 == 1 && oneh5 == 1) {
                                one_5.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_5 && v.getId() == R.id.h1_drop5) {
                    if (oneh5 == 0) {
                        h1_drop5.setText(R.string._98);
                        oneh5 += 1;
                        if (onel5 == 1 && oneh5 == 1) {
                            one_5.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_4 && v.getId() == R.id.h1_drop4) {
                    if (oneh4 == 0) {
                        if (oneh5 == 1) {
                            h1_drop4.setText(R.string._54);
                            oneh4 += 1;
                            if (onel4 == 1 && oneh4 == 1) {
                                one_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_3 && v.getId() == R.id.h1_drop3) {
                    if (oneh3 == 0) {
                        if (oneh4 == 1) {
                            h1_drop3.setText(R.string._21);
                            oneh3 += 1;
                            if (onel3 == 1 && oneh3 == 1) {
                                one_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_2 && v.getId() == R.id.h1_drop2) {
                    if (oneh2 == 0) {
                        if (oneh3 == 1) {
                            h1_drop2.setText(R.string._11);
                            oneh2 += 1;
                            if (onel2 == 1 && oneh2 == 1) {
                                one_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.one_1 && v.getId() == R.id.h1_drop1) {
                    if (oneh1 == 0) {
                        if (oneh2 == 1) {
                            h1_drop1.setText(R.string._4);
                            oneh1 += 1;
                            i += 1;
                            if (onel1 == 1 && oneh1 == 1) {
                                one_1.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_1 && v.getId() == R.id.l2_drop1) {
                    if (twol1 == 0) {
                        l2_drop1.setText(R.string._10);
                        twol1 += 1;
                        if (twol1 == 1 && twoh1 == 1) {
                            two_1.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_2 && v.getId() == R.id.l2_drop2) {
                    if (twol2 == 0) {
                        if (twol1 == 1) {
                            l2_drop2.setText(R.string._32);
                            twol2 += 1;
                            if (twol2 == 1 && twoh2 == 1) {
                                two_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_3 && v.getId() == R.id.l2_drop3) {
                    if (twol3 == 0) {
                        if (twol2 == 1) {
                            l2_drop3.setText(R.string._46);
                            twol3 += 1;
                            if (twol3 == 1 && twoh3 == 1) {
                                two_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_4 && v.getId() == R.id.l2_drop4) {
                    if (twol4 == 0) {
                        if (twol3 == 1) {
                            l2_drop4.setText(R.string._67);
                            twol4 += 1;
                            if (twol4 == 1 && twoh4 == 1) {
                                two_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_5 && v.getId() == R.id.l2_drop5) {
                    if (twol5 == 0) {
                        if (twol4 == 1) {
                            l2_drop5.setText(R.string._89);
                            twol5 += 1;
                            i += 1;
                            if (twol5 == 1 && twoh5 == 1) {
                                two_5.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_5 && v.getId() == R.id.h2_drop5) {
                    if (twoh5 == 0) {
                        h2_drop5.setText(R.string._89);
                        twoh5 += 1;
                        if (twol5 == 1 && twoh5 == 1) {
                            two_5.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_4 && v.getId() == R.id.h2_drop4) {
                    if (twoh4 == 0) {
                        if (twoh5 == 1) {
                            h2_drop4.setText(R.string._67);
                            twoh4 += 1;
                            if (twol4 == 1 && twoh4 == 1) {
                                two_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_3 && v.getId() == R.id.h2_drop3) {
                    if (twoh3 == 0) {
                        if (twoh4 == 1) {
                            h2_drop3.setText(R.string._46);
                            twoh3 += 1;
                            if (twol3 == 1 && twoh3 == 1) {
                                two_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_2 && v.getId() == R.id.h2_drop2) {
                    if (twoh2 == 0) {
                        if (twoh3 == 1) {
                            h2_drop2.setText(R.string._32);
                            twoh2 += 1;
                            if (twol2 == 1 && twoh2 == 1) {
                                two_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.two_1 && v.getId() == R.id.h2_drop1) {
                    if (twoh1 == 0) {
                        if (twoh3 == 1) {
                            h2_drop1.setText(R.string._10);
                            twoh1 += 1;
                            i += 1;
                            if (twol1 == 1 && twoh1 == 1) {
                                two_1.setVisibility(View.GONE);
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_1 && v.getId() == R.id.l3_drop1) {
                    if (threel1 == 0) {
                        l3_drop1.setText(R.string._15);
                        threel1 += 1;
                        if (threel1 == 1 && threeh1 == 1) {
                            three_1.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_2 && v.getId() == R.id.l3_drop2) {
                    if (threel2 == 0) {
                        if (threel1 == 1) {
                            l3_drop2.setText(R.string._32);
                            threel2 += 1;
                            if (threel2 == 1 && threeh2 == 1) {
                                three_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_3 && v.getId() == R.id.l3_drop3) {
                    if (threel3 == 0) {
                        if (threel2 == 1) {
                            l3_drop3.setText(R.string._43);
                            threel3 += 1;
                            if (threel3 == 1 && threeh3 == 1) {
                                three_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_4 && v.getId() == R.id.l3_drop4) {
                    if (threel4 == 0) {
                        if (threel3 == 1) {
                            l3_drop4.setText(R.string._64);
                            threel4 += 1;
                            if (threel4 == 1 && threeh4 == 1) {
                                three_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_5 && v.getId() == R.id.l3_drop5) {
                    if (threel5 == 0) {
                        if (threel4 == 1) {
                            l3_drop5.setText(R.string._79);
                            threel5 += 1;
                            i += 1;
                            if (threel5 == 1 && threeh5 == 1) {
                                three_5.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_5 && v.getId() == R.id.h3_drop5) {
                    if (threeh5 == 0) {
                        h3_drop5.setText(R.string._79);
                        threeh5 += 1;
                        if (threel5 == 1 && threeh5 == 1) {
                            three_5.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_4 && v.getId() == R.id.h3_drop4) {
                    if (threeh4 == 0) {
                        if (threeh5 == 1) {
                            h3_drop4.setText(R.string._64);
                            threeh4 += 1;
                            if (threel4 == 1 && threeh4 == 1) {
                                three_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_3 && v.getId() == R.id.h3_drop3) {
                    if (threeh3 == 0) {
                        if (threeh4 == 1) {
                            h3_drop3.setText(R.string._43);
                            threeh3 += 1;
                            if (threel3 == 1 && threeh3 == 1) {
                                three_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_2 && v.getId() == R.id.h3_drop2) {
                    if (threeh2 == 0) {
                        if (threeh3 == 1) {
                            h3_drop2.setText(R.string._32);
                            threeh2 += 1;
                            if (threel2 == 1 && threeh2 == 1) {
                                three_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.three_1 && v.getId() == R.id.h3_drop1) {
                    if (threeh1 == 0) {
                        if (threeh2 == 1) {
                            h3_drop1.setText(R.string._15);
                            threeh1 += 1;
                            i += 1;
                            if (threel1 == 1 && threeh1 == 1) {
                                three_1.setVisibility(View.GONE);
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_1 && v.getId() == R.id.l4_drop1) {
                    if (fourl1 == 0) {
                        l4_drop1.setText(R.string._21);
                        fourl1 += 1;
                        if (fourl1 == 1 && fourh1 == 1) {
                            four_1.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_2 && v.getId() == R.id.l4_drop2) {
                    if (fourl2 == 0) {
                        if (fourl1 == 1) {
                            l4_drop2.setText(R.string._31);
                            fourl2 += 1;
                            if (fourl2 == 1 && fourh2 == 1) {
                                four_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_3 && v.getId() == R.id.l4_drop3) {
                    if (fourl3 == 0) {
                        if (fourl2 == 1) {
                            l4_drop3.setText(R.string._51);
                            fourl3 += 1;
                            if (fourl3 == 1 && fourh3 == 1) {
                                four_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_4 && v.getId() == R.id.l4_drop4) {
                    if (fourl4 == 0) {
                        if (fourl3 == 1) {
                            l4_drop4.setText(R.string._71);
                            fourl4 += 1;
                            if (fourl4 == 1 && fourh4 == 1) {
                                four_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_5 && v.getId() == R.id.l4_drop5) {
                    if (fourl5 == 0) {
                        if (fourl4 == 1) {
                            l4_drop5.setText(R.string._91);
                            fourl5 += 1;
                            i += 1;
                            if (fourl5 == 1 && fourh5 == 1) {
                                four_5.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_5 && v.getId() == R.id.h4_drop5) {
                    if (fourh5 == 0) {
                        h4_drop5.setText(R.string._91);
                        fourh5 += 1;
                        if (fourl5 == 1 && fourh5 == 1) {
                            four_5.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_4 && v.getId() == R.id.h4_drop4) {
                    if (fourh4 == 0) {
                        if (fourh5 == 1) {
                            h4_drop4.setText(R.string._71);
                            fourh4 += 1;
                            if (fourl4 == 1 && fourh4 == 1) {
                                four_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_3 && v.getId() == R.id.h4_drop3) {
                    if (fourh3 == 0) {
                        if (fourh4 == 1) {
                            h4_drop3.setText(R.string._51);
                            fourh3 += 1;
                            if (fourl3 == 1 && fourh3 == 1) {
                                four_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_2 && v.getId() == R.id.h4_drop2) {
                    if (fourh2 == 0) {
                        if (fourh3 == 1) {
                            h4_drop2.setText(R.string._31);
                            fourh2 += 1;
                            if (fourl2 == 1 && fourh2 == 1) {
                                four_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.four_1 && v.getId() == R.id.h4_drop1) {
                    if (fourh1 == 0) {
                        if (fourh2 == 1) {
                            h4_drop1.setText(R.string._21);
                            fourh1 += 1;
                            i += 1;
                            if (fourl1 == 1 && fourh1 == 1) {
                                four_1.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_1 && v.getId() == R.id.l5_drop1) {
                    if (fivel1 == 0) {
                        l5_drop1.setText(R.string._49);
                        fivel1 += 1;
                        if (fivel1 == 1 && fiveh1 == 1) {
                            five_1.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_2 && v.getId() == R.id.l5_drop2) {
                    if (fivel2 == 0) {
                        if (fivel1 == 1) {
                            l5_drop2.setText(R.string._69);
                            fivel2 += 1;
                            if (fivel2 == 1 && fiveh2 == 1) {
                                five_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_3 && v.getId() == R.id.l5_drop3) {
                    if (fivel3 == 0) {
                        if (fivel2 == 1) {
                            l5_drop3.setText(R.string._89);
                            fivel3 += 1;
                            if (fivel3 == 1 && fiveh3 == 1) {
                                five_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_4 && v.getId() == R.id.l5_drop4) {
                    if (fivel4 == 0) {
                        if (fivel3 == 1) {
                            l5_drop4.setText(R.string._98);
                            fivel4 += 1;
                            if (fivel4 == 1 && fiveh4 == 1) {
                                five_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_5 && v.getId() == R.id.l5_drop5) {
                    if (fivel5 == 0) {
                        if (fivel4 == 1) {
                            l5_drop5.setText(R.string._100);
                            fivel5 += 1;
                            i += 1;
                            if (fivel5 == 1 && fiveh5 == 1) {
                                five_5.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_5 && v.getId() == R.id.h5_drop5) {
                    if (fiveh5 == 0) {
                        h5_drop5.setText(R.string._100);
                        fiveh5 += 1;
                        if (fivel5 == 1 && fiveh5 == 1) {
                            five_5.setVisibility(View.GONE);
                        }
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_4 && v.getId() == R.id.h5_drop4) {
                    if (fiveh4 == 0) {
                        if (fiveh5 == 1) {
                            h5_drop4.setText(R.string._98);
                            fiveh4 += 1;
                            if (fivel4 == 1 && fiveh4 == 1) {
                                five_4.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_3 && v.getId() == R.id.h5_drop3) {
                    if (fiveh3 == 0) {
                        if (fiveh4 == 1) {
                            h5_drop3.setText(R.string._89);
                            fiveh3 += 1;
                            if (fivel3 == 1 && fiveh3 == 1) {
                                five_3.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_2 && v.getId() == R.id.h5_drop2) {
                    if (fiveh2 == 0) {
                        if (fiveh3 == 1) {
                            h5_drop2.setText(R.string._69);
                            fiveh2 += 1;
                            if (fivel2 == 1 && fiveh2 == 1) {
                                five_2.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.five_1 && v.getId() == R.id.h5_drop1) {
                    if (fiveh1 == 0) {
                        if (fiveh2 == 1) {
                            h5_drop1.setText(R.string._49);
                            fiveh1 += 1;
                            i += 1;
                            if (fivel1 == 1 && fiveh1 == 1) {
                                five_1.setVisibility(View.GONE);
                            }
                            if (i == 10) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
                break;

        }
        return true;
    };

    private void initialize() {

        one_1 = findViewById(R.id.one_1);
        one_2 = findViewById(R.id.one_2);
        one_3 = findViewById(R.id.one_3);
        one_4 = findViewById(R.id.one_4);
        one_5 = findViewById(R.id.one_5);
        two_1 = findViewById(R.id.two_1);
        two_2 = findViewById(R.id.two_2);
        two_3 = findViewById(R.id.two_3);
        two_4 = findViewById(R.id.two_4);
        two_5 = findViewById(R.id.two_5);
        three_1 = findViewById(R.id.three_1);
        three_2 = findViewById(R.id.three_2);
        three_3 = findViewById(R.id.three_3);
        three_4 = findViewById(R.id.three_4);
        three_5 = findViewById(R.id.three_5);
        four_1 = findViewById(R.id.four_1);
        four_2 = findViewById(R.id.four_2);
        four_3 = findViewById(R.id.four_3);
        four_4 = findViewById(R.id.four_4);
        four_5 = findViewById(R.id.four_5);
        five_1 = findViewById(R.id.five_1);
        five_2 = findViewById(R.id.five_2);
        five_3 = findViewById(R.id.five_3);
        five_4 = findViewById(R.id.five_4);
        five_5 = findViewById(R.id.five_5);

        l1_drop1 = findViewById(R.id.l1_drop1);
        l1_drop2 = findViewById(R.id.l1_drop2);
        l1_drop3 = findViewById(R.id.l1_drop3);
        l1_drop4 = findViewById(R.id.l1_drop4);
        l1_drop5 = findViewById(R.id.l1_drop5);
        l2_drop1 = findViewById(R.id.l2_drop1);
        l2_drop2 = findViewById(R.id.l2_drop2);
        l2_drop3 = findViewById(R.id.l2_drop3);
        l2_drop4 = findViewById(R.id.l2_drop4);
        l2_drop5 = findViewById(R.id.l2_drop5);
        l3_drop1 = findViewById(R.id.l3_drop1);
        l3_drop2 = findViewById(R.id.l3_drop2);
        l3_drop3 = findViewById(R.id.l3_drop3);
        l3_drop4 = findViewById(R.id.l3_drop4);
        l3_drop5 = findViewById(R.id.l3_drop5);
        l4_drop1 = findViewById(R.id.l4_drop1);
        l4_drop2 = findViewById(R.id.l4_drop2);
        l4_drop3 = findViewById(R.id.l4_drop3);
        l4_drop4 = findViewById(R.id.l4_drop4);
        l4_drop5 = findViewById(R.id.l4_drop5);
        l5_drop1 = findViewById(R.id.l5_drop1);
        l5_drop2 = findViewById(R.id.l5_drop2);
        l5_drop3 = findViewById(R.id.l5_drop3);
        l5_drop4 = findViewById(R.id.l5_drop4);
        l5_drop5 = findViewById(R.id.l5_drop5);

        h1_drop1 = findViewById(R.id.h1_drop1);
        h1_drop2 = findViewById(R.id.h1_drop2);
        h1_drop3 = findViewById(R.id.h1_drop3);
        h1_drop4 = findViewById(R.id.h1_drop4);
        h1_drop5 = findViewById(R.id.h1_drop5);
        h2_drop1 = findViewById(R.id.h2_drop1);
        h2_drop2 = findViewById(R.id.h2_drop2);
        h2_drop3 = findViewById(R.id.h2_drop3);
        h2_drop4 = findViewById(R.id.h2_drop4);
        h2_drop5 = findViewById(R.id.h2_drop5);
        h3_drop1 = findViewById(R.id.h3_drop1);
        h3_drop2 = findViewById(R.id.h3_drop2);
        h3_drop3 = findViewById(R.id.h3_drop3);
        h3_drop4 = findViewById(R.id.h3_drop4);
        h3_drop5 = findViewById(R.id.h3_drop5);
        h4_drop1 = findViewById(R.id.h4_drop1);
        h4_drop2 = findViewById(R.id.h4_drop2);
        h4_drop3 = findViewById(R.id.h4_drop3);
        h4_drop4 = findViewById(R.id.h4_drop4);
        h4_drop5 = findViewById(R.id.h4_drop5);
        h5_drop1 = findViewById(R.id.h5_drop1);
        h5_drop2 = findViewById(R.id.h5_drop2);
        h5_drop3 = findViewById(R.id.h5_drop3);
        h5_drop4 = findViewById(R.id.h5_drop4);
        h5_drop5 = findViewById(R.id.h5_drop5);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity6.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title) // "Hurray!"
                    .setContentText(message) // "Activity Cleared."
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            onclickNext();
                        }
                    })
                    .show();
        } else {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity6.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity6.this, SeniorNumeracyActivity7.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity6.this, SeniorNumeracyActivity5.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

    private void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Ascending and Descending (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity6.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }

    private void musiccontrol() {

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(SeniorNumeracyActivity6.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity6.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity6.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back) {
            onclickBack();
        } else if (v.getId() == R.id.next) {
            onclickNext();
        }
    }

}
